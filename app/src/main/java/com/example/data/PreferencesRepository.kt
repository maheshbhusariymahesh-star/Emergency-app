package com.example.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.model.AppLanguage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "vishnu_raksha_prefs")

class PreferencesRepository(private val context: Context) {

    private object Keys {
        val PINNED_IDS = stringSetPreferencesKey("pinned_emergency_ids")
        val LANGUAGE = stringPreferencesKey("app_language")
    }

    val pinnedIdsFlow: Flow<Set<String>> = context.dataStore.data.map { prefs ->
        prefs[Keys.PINNED_IDS] ?: setOf("sos_112", "women_1091", "cyber_1930")
    }

    val languageFlow: Flow<AppLanguage> = context.dataStore.data.map { prefs ->
        val code = prefs[Keys.LANGUAGE]
        AppLanguage.entries.firstOrNull { it.code == code } ?: AppLanguage.BILINGUAL
    }

    suspend fun togglePin(id: String) {
        context.dataStore.edit { prefs ->
            val current = prefs[Keys.PINNED_IDS] ?: setOf("sos_112", "women_1091", "cyber_1930")
            prefs[Keys.PINNED_IDS] = if (current.contains(id)) current - id else current + id
        }
    }

    suspend fun setLanguage(language: AppLanguage) {
        context.dataStore.edit { prefs ->
            prefs[Keys.LANGUAGE] = language.code
        }
    }
}
