package com.example.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.rounded.AccountBalance
import androidx.compose.material.icons.rounded.Agriculture
import androidx.compose.material.icons.rounded.Bloodtype
import androidx.compose.material.icons.rounded.Bolt
import androidx.compose.material.icons.rounded.Bookmark
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.ChildCare
import androidx.compose.material.icons.rounded.ContentCopy
import androidx.compose.material.icons.rounded.DirectionsCar
import androidx.compose.material.icons.rounded.Elderly
import androidx.compose.material.icons.rounded.Female
import androidx.compose.material.icons.rounded.Flood
import androidx.compose.material.icons.rounded.LocalFireDepartment
import androidx.compose.material.icons.rounded.LocalHospital
import androidx.compose.material.icons.rounded.LocalPolice
import androidx.compose.material.icons.rounded.Luggage
import androidx.compose.material.icons.rounded.MedicalServices
import androidx.compose.material.icons.rounded.PropaneTank
import androidx.compose.material.icons.rounded.Psychology
import androidx.compose.material.icons.rounded.Route
import androidx.compose.material.icons.rounded.Security
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material.icons.rounded.Sos
import androidx.compose.material.icons.rounded.Train
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.model.AppLanguage
import com.example.model.EmergencyNumber
import com.example.model.HelplineIconType
import com.example.ui.theme.EmergencyCrimson
import com.example.ui.theme.SacredGold

@Composable
fun EmergencyCard(
    item: EmergencyNumber,
    language: AppLanguage,
    isPinned: Boolean,
    onCall: () -> Unit,
    onCopy: () -> Unit,
    onShare: () -> Unit,
    onTogglePin: () -> Unit,
    modifier: Modifier = Modifier
) {
    val accent = item.category.accentColor

    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("emergency_card_${item.number}"),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        border = BorderStroke(
            width = if (isPinned) 1.2.dp else 1.dp,
            color = if (isPinned) SacredGold.copy(alpha = 0.7f) else MaterialTheme.colorScheme.outline.copy(alpha = 0.6f)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top
            ) {
                Surface(
                    shape = RoundedCornerShape(14.dp),
                    color = accent.copy(alpha = 0.13f),
                    modifier = Modifier.size(48.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = helplineIcon(item.iconType),
                            contentDescription = null,
                            tint = accent,
                            modifier = Modifier.size(26.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = item.number,
                            style = MaterialTheme.typography.headlineSmall.copy(
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 22.sp
                            ),
                            color = if (item.isPrimarySos) EmergencyCrimson else MaterialTheme.colorScheme.primary
                        )

                        Surface(
                            shape = RoundedCornerShape(50),
                            color = accent.copy(alpha = 0.12f)
                        ) {
                            Text(
                                text = if (language == AppLanguage.HINDI) item.badgeHi else item.badgeEn,
                                style = MaterialTheme.typography.labelSmall.copy(
                                    fontWeight = FontWeight.SemiBold
                                ),
                                color = accent,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(2.dp))

                    when (language) {
                        AppLanguage.HINDI -> {
                            Text(
                                text = item.titleHi,
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = item.descriptionHi,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )
                        }

                        AppLanguage.ENGLISH -> {
                            Text(
                                text = item.titleEn,
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = item.descriptionEn,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )
                        }

                        AppLanguage.BILINGUAL -> {
                            Text(
                                text = item.titleHi,
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = item.titleEn,
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.height(3.dp))
                            Text(
                                text = item.descriptionHi,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(
                        onClick = onTogglePin,
                        modifier = Modifier
                            .minimumInteractiveComponentSize()
                            .testTag("pin_button_${item.number}")
                    ) {
                        Icon(
                            imageVector = if (isPinned) Icons.Rounded.Bookmark else Icons.Outlined.BookmarkBorder,
                            contentDescription = stringResource(R.string.cd_pin_number, item.number),
                            tint = if (isPinned) SacredGold else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    IconButton(
                        onClick = onCopy,
                        modifier = Modifier
                            .minimumInteractiveComponentSize()
                            .testTag("copy_button_${item.number}")
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.ContentCopy,
                            contentDescription = stringResource(R.string.cd_copy_number, item.number),
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    IconButton(
                        onClick = onShare,
                        modifier = Modifier
                            .minimumInteractiveComponentSize()
                            .testTag("share_button_${item.number}")
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Share,
                            contentDescription = stringResource(R.string.cd_share_number, item.number),
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                Button(
                    onClick = onCall,
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (item.isPrimarySos) EmergencyCrimson else MaterialTheme.colorScheme.primary,
                        contentColor = Color.White
                    ),
                    contentPadding = PaddingValues(horizontal = 18.dp, vertical = 10.dp),
                    modifier = Modifier
                        .minimumInteractiveComponentSize()
                        .testTag("call_button_${item.number}")
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Call,
                        contentDescription = stringResource(R.string.cd_call_number, item.number),
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = when (language) {
                            AppLanguage.HINDI -> "कॉल करें"
                            AppLanguage.ENGLISH -> stringResource(R.string.call_label)
                            AppLanguage.BILINGUAL -> "कॉल / Call"
                        },
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
        }
    }
}

private fun helplineIcon(type: HelplineIconType): ImageVector = when (type) {
    HelplineIconType.SOS -> Icons.Rounded.Sos
    HelplineIconType.POLICE -> Icons.Rounded.LocalPolice
    HelplineIconType.FIRE -> Icons.Rounded.LocalFireDepartment
    HelplineIconType.AMBULANCE -> Icons.Rounded.LocalHospital
    HelplineIconType.WOMEN -> Icons.Rounded.Female
    HelplineIconType.CHILD -> Icons.Rounded.ChildCare
    HelplineIconType.SENIOR -> Icons.Rounded.Elderly
    HelplineIconType.MEDICAL -> Icons.Rounded.MedicalServices
    HelplineIconType.MENTAL_HEALTH -> Icons.Rounded.Psychology
    HelplineIconType.BLOOD -> Icons.Rounded.Bloodtype
    HelplineIconType.ROAD -> Icons.Rounded.DirectionsCar
    HelplineIconType.HIGHWAY -> Icons.Rounded.Route
    HelplineIconType.RAILWAY -> Icons.Rounded.Train
    HelplineIconType.DISASTER -> Icons.Rounded.Flood
    HelplineIconType.CYBER -> Icons.Rounded.Security
    HelplineIconType.GAS -> Icons.Rounded.PropaneTank
    HelplineIconType.ELECTRICITY -> Icons.Rounded.Bolt
    HelplineIconType.FARMER -> Icons.Rounded.Agriculture
    HelplineIconType.TOURIST -> Icons.Rounded.Luggage
    HelplineIconType.CORRUPTION -> Icons.Rounded.AccountBalance
}
