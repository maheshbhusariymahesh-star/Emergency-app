package com.example.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.LocalFireDepartment
import androidx.compose.material.icons.rounded.LocalHospital
import androidx.compose.material.icons.rounded.LocalPolice
import androidx.compose.material.icons.rounded.Sos
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
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
import com.example.ui.theme.EmergencyCrimson
import com.example.ui.theme.EmergencyCrimsonBright
import com.example.ui.theme.FireAmber
import com.example.ui.theme.MedicalEmerald
import com.example.ui.theme.PoliceBlue

@Composable
fun QuickSosSection(
    language: AppLanguage,
    onCallNumber: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        // Primary 112 SOS Banner
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .testTag("sos_112_banner"),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(EmergencyCrimson, EmergencyCrimsonBright)
                        )
                    )
                    .padding(horizontal = 16.dp, vertical = 14.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier.weight(1f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = Color.White.copy(alpha = 0.2f),
                            modifier = Modifier.size(44.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Rounded.Sos,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(26.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(
                                text = when (language) {
                                    AppLanguage.HINDI -> "राष्ट्रीय आपातकाल (112)"
                                    AppLanguage.ENGLISH -> stringResource(R.string.sos_banner_title)
                                    AppLanguage.BILINGUAL -> "आपातकाल SOS • Emergency"
                                },
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.Bold
                                ),
                                color = Color.White,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = when (language) {
                                    AppLanguage.HINDI -> "पुलिस • दमकल • एम्बुलेंस (24x7 निःशुल्क)"
                                    AppLanguage.ENGLISH -> stringResource(R.string.sos_banner_subtitle)
                                    AppLanguage.BILINGUAL -> "पुलिस • Fire • एम्बुलेंस (24x7)"
                                },
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color.White.copy(alpha = 0.9f),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Button(
                        onClick = { onCallNumber("112") },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = EmergencyCrimson
                        ),
                        shape = RoundedCornerShape(14.dp),
                        contentPadding = PaddingValues(horizontal = 14.dp, vertical = 10.dp),
                        modifier = Modifier.testTag("call_112_sos_button")
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Call,
                            contentDescription = stringResource(R.string.cd_call_number, "112"),
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "112",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 17.sp
                            )
                        )
                    }
                }
            }
        }

        // Fast 3-tile quick dial grid: Police 100, Ambulance 108, Fire 101
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            QuickDialTile(
                number = "100",
                label = when (language) {
                    AppLanguage.HINDI -> "पुलिस"
                    AppLanguage.ENGLISH -> "Police"
                    AppLanguage.BILINGUAL -> "पुलिस / Police"
                },
                icon = Icons.Rounded.LocalPolice,
                accentColor = PoliceBlue,
                onClick = { onCallNumber("100") },
                modifier = Modifier.weight(1f)
            )
            QuickDialTile(
                number = "108",
                label = when (language) {
                    AppLanguage.HINDI -> "एम्बुलेंस"
                    AppLanguage.ENGLISH -> "Ambulance"
                    AppLanguage.BILINGUAL -> "एम्बुलेंस"
                },
                icon = Icons.Rounded.LocalHospital,
                accentColor = MedicalEmerald,
                onClick = { onCallNumber("108") },
                modifier = Modifier.weight(1f)
            )
            QuickDialTile(
                number = "101",
                label = when (language) {
                    AppLanguage.HINDI -> "दमकल"
                    AppLanguage.ENGLISH -> "Fire"
                    AppLanguage.BILINGUAL -> "दमकल / Fire"
                },
                icon = Icons.Rounded.LocalFireDepartment,
                accentColor = FireAmber,
                onClick = { onCallNumber("101") },
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun QuickDialTile(
    number: String,
    label: String,
    icon: ImageVector,
    accentColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        onClick = onClick,
        modifier = modifier.testTag("quick_tile_$number"),
        shape = RoundedCornerShape(18.dp),
        color = MaterialTheme.colorScheme.surface,
        border = BorderStroke(1.dp, accentColor.copy(alpha = 0.28f)),
        tonalElevation = 2.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                shape = CircleShape,
                color = accentColor.copy(alpha = 0.14f),
                modifier = Modifier.size(38.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = icon,
                        contentDescription = stringResource(R.string.cd_call_number, number),
                        tint = accentColor,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = number,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.ExtraBold
                ),
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
