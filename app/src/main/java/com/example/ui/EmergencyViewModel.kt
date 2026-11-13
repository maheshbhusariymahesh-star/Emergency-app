package com.example.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.data.EmergencyDirectory
import com.example.data.PreferencesRepository
import com.example.model.AppLanguage
import com.example.model.AppTab
import com.example.model.EmergencyCategory
import com.example.model.EmergencyNumber
import com.example.model.SafetyGuide
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class EmergencyUiState(
    val selectedTab: AppTab = AppTab.DIRECTORY,
    val searchQuery: String = "",
    val selectedCategory: EmergencyCategory = EmergencyCategory.ALL,
    val language: AppLanguage = AppLanguage.BILINGUAL,
    val pinnedIds: Set<String> = emptySet(),
    val allNumbers: List<EmergencyNumber> = EmergencyDirectory.numbers,
    val filteredNumbers: List<EmergencyNumber> = EmergencyDirectory.numbers,
    val pinnedNumbers: List<EmergencyNumber> = emptyList(),
    val safetyGuides: List<SafetyGuide> = EmergencyDirectory.safetyGuides,
    val isFullDarshanOpen: Boolean = false
)

class EmergencyViewModel(
    private val preferencesRepository: PreferencesRepository
) : ViewModel() {

    private data class LocalState(
        val selectedTab: AppTab = AppTab.DIRECTORY,
        val searchQuery: String = "",
        val selectedCategory: EmergencyCategory = EmergencyCategory.ALL,
        val isFullDarshanOpen: Boolean = false
    )

    private val localState = MutableStateFlow(LocalState())

    val uiState: StateFlow<EmergencyUiState> = combine(
        localState,
        preferencesRepository.pinnedIdsFlow,
        preferencesRepository.languageFlow
    ) { local, pinnedIds, language ->
        val query = local.searchQuery.trim().lowercase()
        val filtered = EmergencyDirectory.numbers.filter { item ->
            val matchesCategory = local.selectedCategory == EmergencyCategory.ALL ||
                item.category == local.selectedCategory
            val matchesQuery = query.isEmpty() ||
                item.number.contains(query) ||
                item.titleEn.lowercase().contains(query) ||
                item.titleHi.lowercase().contains(query) ||
                item.descriptionEn.lowercase().contains(query) ||
                item.descriptionHi.lowercase().contains(query) ||
                item.keywords.lowercase().contains(query)
            matchesCategory && matchesQuery
        }

        val pinned = EmergencyDirectory.numbers.filter { pinnedIds.contains(it.id) }

        EmergencyUiState(
            selectedTab = local.selectedTab,
            searchQuery = local.searchQuery,
            selectedCategory = local.selectedCategory,
            language = language,
            pinnedIds = pinnedIds,
            allNumbers = EmergencyDirectory.numbers,
            filteredNumbers = filtered,
            pinnedNumbers = pinned,
            safetyGuides = EmergencyDirectory.safetyGuides,
            isFullDarshanOpen = local.isFullDarshanOpen
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = EmergencyUiState()
    )

    fun selectTab(tab: AppTab) {
        localState.update { it.copy(selectedTab = tab) }
    }

    fun updateSearchQuery(query: String) {
        localState.update { it.copy(searchQuery = query) }
    }

    fun selectCategory(category: EmergencyCategory) {
        localState.update { it.copy(selectedCategory = category) }
    }

    fun resetFilters() {
        localState.update { it.copy(searchQuery = "", selectedCategory = EmergencyCategory.ALL) }
    }

    fun togglePin(id: String) {
        viewModelScope.launch {
            preferencesRepository.togglePin(id)
        }
    }

    fun cycleLanguage() {
        val next = when (uiState.value.language) {
            AppLanguage.BILINGUAL -> AppLanguage.HINDI
            AppLanguage.HINDI -> AppLanguage.ENGLISH
            AppLanguage.ENGLISH -> AppLanguage.BILINGUAL
        }
        viewModelScope.launch {
            preferencesRepository.setLanguage(next)
        }
    }

    fun setFullDarshanOpen(open: Boolean) {
        localState.update { it.copy(isFullDarshanOpen = open) }
    }

    class Factory(
        private val preferencesRepository: PreferencesRepository
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return EmergencyViewModel(preferencesRepository) as T
        }
    }
}
