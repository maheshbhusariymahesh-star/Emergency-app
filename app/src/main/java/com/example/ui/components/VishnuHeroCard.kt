package com.example.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AutoAwesome
import androidx.compose.material.icons.rounded.Fullscreen
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.model.AppLanguage
import com.example.ui.theme.SacredGold

@Composable
fun VishnuHeroCard(
    language: AppLanguage,
    onOpenFullDarshan: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("vishnu_hero_card"),
        shape = RoundedCornerShape(24.dp),
        border = BorderStroke(1.5.dp, SacredGold.copy(alpha = 0.75f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(4f / 3f)
                .clickable(onClick = onOpenFullDarshan)
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_lord_vishnu),
                contentDescription = stringResource(R.string.cd_lord_vishnu_photo),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            // Bottom gradient scrim so Lord Vishnu's face and lotus remain bright and clear
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color(0xAA09152E),
                                Color(0xE6081228)
                            )
                        )
                    )
                    .padding(horizontal = 16.dp, vertical = 14.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Rounded.AutoAwesome,
                                contentDescription = null,
                                tint = SacredGold,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = when (language) {
                                    AppLanguage.ENGLISH -> "Om Namo Bhagavate Vasudevaya"
                                    else -> "ॐ नमो भगवते वासुदेवाय"
                                },
                                style = MaterialTheme.typography.titleSmall.copy(
                                    fontWeight = FontWeight.Bold
                                ),
                                color = Color(0xFFFFE082),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                        Text(
                            text = when (language) {
                                AppLanguage.HINDI -> "श्री विष्णु रक्षा • सदैव आपकी सुरक्षा में"
                                AppLanguage.ENGLISH -> "Lord Vishnu's Blessing • Always Protected"
                                AppLanguage.BILINGUAL -> "श्री विष्णु रक्षा • Always Protected"
                            },
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.White.copy(alpha = 0.92f),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Surface(
                        onClick = onOpenFullDarshan,
                        shape = RoundedCornerShape(50),
                        color = SacredGold.copy(alpha = 0.22f),
                        border = BorderStroke(1.dp, SacredGold.copy(alpha = 0.85f)),
                        modifier = Modifier.testTag("full_darshan_pill_button")
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.Fullscreen,
                                contentDescription = stringResource(R.string.view_full_darshan),
                                tint = Color(0xFFFFE082),
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = when (language) {
                                    AppLanguage.HINDI -> "दर्शन"
                                    AppLanguage.ENGLISH -> "Darshan"
                                    AppLanguage.BILINGUAL -> "दर्शन"
                                },
                                style = MaterialTheme.typography.labelMedium.copy(
                                    fontWeight = FontWeight.SemiBold
                                ),
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}
