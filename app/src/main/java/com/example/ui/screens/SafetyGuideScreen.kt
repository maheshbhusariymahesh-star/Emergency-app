package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.ExpandLess
import androidx.compose.material.icons.rounded.ExpandMore
import androidx.compose.material.icons.rounded.HealthAndSafety
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.model.AppLanguage
import com.example.model.SafetyGuide
import com.example.ui.theme.EmergencyCrimson

@Composable
fun SafetyGuideScreen(
    guides: List<SafetyGuide>,
    language: AppLanguage,
    onCallNumber: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var expandedGuideId by rememberSaveable { mutableStateOf(guides.firstOrNull()?.id) }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        LazyColumn(
            modifier = Modifier
                .widthIn(max = 680.dp)
                .fillMaxSize()
                .testTag("safety_guide_list"),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 14.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item(key = "safety_header") {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        shape = CircleShape,
                        color = MaterialTheme.colorScheme.primaryContainer,
                        modifier = Modifier.size(44.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Icon(
                                imageVector = Icons.Rounded.HealthAndSafety,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = when (language) {
                                AppLanguage.HINDI -> "आपातकालीन सुरक्षा गाइड"
                                AppLanguage.ENGLISH -> "Offline Safety Action Guide"
                                AppLanguage.BILINGUAL -> "सुरक्षा गाइड • Safety Guide"
                            },
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontWeight = FontWeight.Bold
                            ),
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        Text(
                            text = when (language) {
                                AppLanguage.HINDI -> "मदद आने तक क्या करें — त्वरित निर्देश"
                                AppLanguage.ENGLISH -> "Essential first steps while help is on the way"
                                AppLanguage.BILINGUAL -> "तत्काल प्राथमिक कदम • First Steps"
                            },
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            items(guides, key = { it.id }) { guide ->
                val isExpanded = expandedGuideId == guide.id
                val accent = guide.category.accentColor

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("safety_guide_${guide.id}"),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    ),
                    border = BorderStroke(
                        width = 1.dp,
                        color = if (isExpanded) accent.copy(alpha = 0.55f) else MaterialTheme.colorScheme.outline
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                expandedGuideId = if (isExpanded) null else guide.id
                            }
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = when (language) {
                                        AppLanguage.ENGLISH -> guide.titleEn
                                        else -> guide.titleHi
                                    },
                                    style = MaterialTheme.typography.titleMedium.copy(
                                        fontWeight = FontWeight.Bold
                                    ),
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                if (language == AppLanguage.BILINGUAL) {
                                    Text(
                                        text = guide.titleEn,
                                        style = MaterialTheme.typography.labelMedium,
                                        color = accent
                                    )
                                }
                                Spacer(modifier = Modifier.height(3.dp))
                                Text(
                                    text = if (language == AppLanguage.ENGLISH) guide.summaryEn else guide.summaryHi,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }

                            Spacer(modifier = Modifier.width(8.dp))

                            Icon(
                                imageVector = if (isExpanded) Icons.Rounded.ExpandLess else Icons.Rounded.ExpandMore,
                                contentDescription = if (isExpanded) "Collapse" else "Expand",
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        AnimatedVisibility(visible = isExpanded) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 12.dp),
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                val steps = if (language == AppLanguage.ENGLISH) guide.stepsEn else guide.stepsHi
                                steps.forEachIndexed { index, step ->
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        verticalAlignment = Alignment.Top
                                    ) {
                                        Surface(
                                            shape = CircleShape,
                                            color = accent.copy(alpha = 0.15f),
                                            modifier = Modifier.size(24.dp)
                                        ) {
                                            Box(contentAlignment = Alignment.Center) {
                                                Text(
                                                    text = "${index + 1}",
                                                    style = MaterialTheme.typography.labelMedium.copy(
                                                        fontWeight = FontWeight.Bold
                                                    ),
                                                    color = accent
                                                )
                                            }
                                        }
                                        Spacer(modifier = Modifier.width(10.dp))
                                        Text(
                                            text = step,
                                            style = MaterialTheme.typography.bodyLarge,
                                            color = MaterialTheme.colorScheme.onSurface,
                                            modifier = Modifier.weight(1f)
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.height(4.dp))

                                Button(
                                    onClick = { onCallNumber(guide.primaryNumber) },
                                    shape = RoundedCornerShape(14.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = EmergencyCrimson,
                                        contentColor = Color.White
                                    ),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .testTag("guide_call_${guide.primaryNumber}")
                                ) {
                                    Icon(
                                        imageVector = Icons.Rounded.Call,
                                        contentDescription = stringResource(R.string.cd_call_number, guide.primaryNumber),
                                        modifier = Modifier.size(18.dp)
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(
                                        text = if (language == AppLanguage.ENGLISH) {
                                            guide.primaryNumberLabelEn
                                        } else {
                                            guide.primaryNumberLabelHi
                                        },
                                        style = MaterialTheme.typography.labelLarge
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
