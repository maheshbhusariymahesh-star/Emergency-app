package com.example.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Bookmark
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.SearchOff
import androidx.compose.material.icons.rounded.Translate
import androidx.compose.material3.Button
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.model.AppLanguage
import com.example.model.EmergencyCategory
import com.example.model.EmergencyNumber
import com.example.ui.EmergencyUiState
import com.example.ui.components.EmergencyCard
import com.example.ui.components.QuickSosSection
import com.example.ui.components.VishnuHeroCard
import com.example.ui.theme.SacredGold

@Composable
fun EmergencyDirectoryScreen(
    uiState: EmergencyUiState,
    onSearchQueryChange: (String) -> Unit,
    onSelectCategory: (EmergencyCategory) -> Unit,
    onResetFilters: () -> Unit,
    onCallNumber: (String) -> Unit,
    onCopyNumber: (EmergencyNumber) -> Unit,
    onShareNumber: (EmergencyNumber) -> Unit,
    onTogglePin: (String) -> Unit,
    onCycleLanguage: () -> Unit,
    onOpenFullDarshan: () -> Unit,
    modifier: Modifier = Modifier
) {
    val showPinnedSection = uiState.searchQuery.isBlank() &&
        uiState.selectedCategory == EmergencyCategory.ALL &&
        uiState.pinnedNumbers.isNotEmpty()

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        LazyColumn(
            modifier = Modifier
                .widthIn(max = 680.dp)
                .fillMaxSize()
                .testTag("emergency_directory_list"),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Top Branding & Language Toggle Header
            item(key = "header") {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier.weight(1f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.img_launcher_emblem),
                            contentDescription = stringResource(R.string.cd_app_emblem),
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(44.dp)
                                .clip(CircleShape)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(
                                text = when (uiState.language) {
                                    AppLanguage.HINDI -> stringResource(R.string.app_title_hindi)
                                    AppLanguage.ENGLISH -> stringResource(R.string.app_name)
                                    AppLanguage.BILINGUAL -> "विष्णु रक्षा • Vishnu Raksha"
                                },
                                style = MaterialTheme.typography.titleLarge.copy(
                                    fontWeight = FontWeight.Bold
                                ),
                                color = MaterialTheme.colorScheme.onBackground
                            )
                            Text(
                                text = when (uiState.language) {
                                    AppLanguage.HINDI -> "सभी आपातकालीन हेल्पलाइन नंबर"
                                    AppLanguage.ENGLISH -> "All Emergency Helplines"
                                    AppLanguage.BILINGUAL -> "सभी आपातकालीन नंबर • All Helplines"
                                },
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    Surface(
                        onClick = onCycleLanguage,
                        shape = RoundedCornerShape(50),
                        color = MaterialTheme.colorScheme.secondaryContainer,
                        border = BorderStroke(1.dp, SacredGold.copy(alpha = 0.55f)),
                        modifier = Modifier
                            .minimumInteractiveComponentSize()
                            .testTag("language_toggle_button")
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.Translate,
                                contentDescription = "Switch language",
                                tint = MaterialTheme.colorScheme.onSecondaryContainer,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = uiState.language.label,
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontWeight = FontWeight.Bold
                                ),
                                color = MaterialTheme.colorScheme.onSecondaryContainer
                            )
                        }
                    }
                }
            }

            // Prominent Lord Vishnu Photo Hero Card on Screen
            item(key = "vishnu_hero") {
                VishnuHeroCard(
                    language = uiState.language,
                    onOpenFullDarshan = onOpenFullDarshan
                )
            }

            // Instant 112 SOS & 100 / 108 / 101 Quick Dial Tiles
            item(key = "quick_sos") {
                QuickSosSection(
                    language = uiState.language,
                    onCallNumber = onCallNumber
                )
            }

            // Search Bar
            item(key = "search_bar") {
                OutlinedTextField(
                    value = uiState.searchQuery,
                    onValueChange = onSearchQueryChange,
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("search_helpline_input"),
                    placeholder = {
                        Text(
                            text = when (uiState.language) {
                                AppLanguage.HINDI -> "नंबर या सेवा खोजें (जैसे 108, पुलिस, साइबर)…"
                                AppLanguage.ENGLISH -> "Search number or service (e.g. 108, Police, Cyber)…"
                                AppLanguage.BILINGUAL -> stringResource(R.string.search_placeholder)
                            },
                            maxLines = 1
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Rounded.Search,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                    },
                    trailingIcon = {
                        if (uiState.searchQuery.isNotEmpty()) {
                            IconButton(
                                onClick = { onSearchQueryChange("") },
                                modifier = Modifier.testTag("clear_search_button")
                            ) {
                                Icon(
                                    imageVector = Icons.Rounded.Clear,
                                    contentDescription = stringResource(R.string.cd_clear_search)
                                )
                            }
                        }
                    },
                    singleLine = true,
                    shape = RoundedCornerShape(18.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = MaterialTheme.colorScheme.surface,
                        unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                        focusedBorderColor = MaterialTheme.colorScheme.primary,
                        unfocusedBorderColor = MaterialTheme.colorScheme.outline
                    )
                )
            }

            // Category Filter Chips
            item(key = "category_chips") {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(EmergencyCategory.entries, key = { it.name }) { category ->
                        val selected = uiState.selectedCategory == category
                        FilterChip(
                            selected = selected,
                            onClick = { onSelectCategory(category) },
                            label = {
                                Text(
                                    text = when (uiState.language) {
                                        AppLanguage.HINDI -> category.labelHi
                                        AppLanguage.ENGLISH -> category.labelEn
                                        AppLanguage.BILINGUAL -> if (category == EmergencyCategory.ALL) {
                                            "सभी / All"
                                        } else {
                                            "${category.labelHi} (${category.labelEn})"
                                        }
                                    },
                                    style = MaterialTheme.typography.labelLarge
                                )
                            },
                            shape = RoundedCornerShape(50),
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = MaterialTheme.colorScheme.primary,
                                selectedLabelColor = MaterialTheme.colorScheme.onPrimary
                            ),
                            modifier = Modifier.testTag("category_chip_${category.name}")
                        )
                    }
                }
            }

            // Pinned Section
            if (showPinnedSection) {
                item(key = "pinned_header") {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(top = 4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Bookmark,
                            contentDescription = null,
                            tint = SacredGold,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = when (uiState.language) {
                                AppLanguage.HINDI -> "पिन किए गए मुख्य नंबर"
                                AppLanguage.ENGLISH -> stringResource(R.string.pinned_section_title)
                                AppLanguage.BILINGUAL -> "पिन किए गए नंबर • Pinned"
                            },
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold
                            ),
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                }

                items(uiState.pinnedNumbers, key = { "pinned_${it.id}" }) { item ->
                    EmergencyCard(
                        item = item,
                        language = uiState.language,
                        isPinned = true,
                        onCall = { onCallNumber(item.number) },
                        onCopy = { onCopyNumber(item) },
                        onShare = { onShareNumber(item) },
                        onTogglePin = { onTogglePin(item.id) }
                    )
                }
            }

            // All Numbers Section Header
            item(key = "all_header") {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = when (uiState.language) {
                            AppLanguage.HINDI -> "सभी आपातकालीन सेवाएं"
                            AppLanguage.ENGLISH -> stringResource(R.string.all_numbers_section_title)
                            AppLanguage.BILINGUAL -> "सभी सेवाएं • All Numbers"
                        },
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Text(
                        text = "${uiState.filteredNumbers.size}",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            if (uiState.filteredNumbers.isEmpty()) {
                item(key = "empty_state") {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp),
                        shape = RoundedCornerShape(20.dp),
                        color = MaterialTheme.colorScheme.surface,
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.SearchOff,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(44.dp)
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = when (uiState.language) {
                                    AppLanguage.HINDI -> "कोई नंबर नहीं मिला"
                                    else -> stringResource(R.string.empty_search_title)
                                },
                                style = MaterialTheme.typography.titleMedium,
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = when (uiState.language) {
                                    AppLanguage.HINDI -> "कृपया 112, 108, 1930 खोजें या सभी श्रेणियां देखें।"
                                    else -> stringResource(R.string.empty_search_subtitle)
                                },
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.height(14.dp))
                            Button(
                                onClick = onResetFilters,
                                modifier = Modifier.testTag("reset_filters_button")
                            ) {
                                Text(
                                    text = when (uiState.language) {
                                        AppLanguage.HINDI -> "सभी नंबर दिखाएं"
                                        else -> stringResource(R.string.reset_filters)
                                    }
                                )
                            }
                        }
                    }
                }
            } else {
                items(uiState.filteredNumbers, key = { it.id }) { item ->
                    EmergencyCard(
                        item = item,
                        language = uiState.language,
                        isPinned = uiState.pinnedIds.contains(item.id),
                        onCall = { onCallNumber(item.number) },
                        onCopy = { onCopyNumber(item) },
                        onShare = { onShareNumber(item) },
                        onTogglePin = { onTogglePin(item.id) }
                    )
                }
            }

            item(key = "bottom_spacer") {
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}
