package com.example.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AutoAwesome
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Shield
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.model.AppLanguage
import com.example.ui.theme.EmergencyCrimson
import com.example.ui.theme.SacredGold

@Composable
fun VishnuDarshanScreen(
    language: AppLanguage,
    onCallSos: () -> Unit,
    onCloseModal: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF0A1633),
                        Color(0xFF132652),
                        Color(0xFF091227)
                    )
                )
            ),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .widthIn(max = 640.dp)
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(horizontal = 18.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Rounded.AutoAwesome,
                        contentDescription = null,
                        tint = SacredGold,
                        modifier = Modifier.size(22.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = when (language) {
                            AppLanguage.HINDI -> "श्री विष्णु दर्शन"
                            AppLanguage.ENGLISH -> "Lord Vishnu Darshan"
                            AppLanguage.BILINGUAL -> "श्री विष्णु दर्शन • Lord Vishnu"
                        },
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        color = Color(0xFFFFE599)
                    )
                }

                if (onCloseModal != null) {
                    IconButton(
                        onClick = onCloseModal,
                        modifier = Modifier
                            .minimumInteractiveComponentSize()
                            .testTag("close_darshan_modal")
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Close,
                            contentDescription = stringResource(R.string.cd_back),
                            tint = Color.White
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Full Unobstructed Sacred Portrait of Lord Vishnu
            Card(
                shape = RoundedCornerShape(26.dp),
                border = BorderStroke(2.dp, SacredGold.copy(alpha = 0.85f)),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("darshan_full_image")
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_lord_vishnu),
                    contentDescription = stringResource(R.string.cd_lord_vishnu_photo),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(4f / 3f)
                )
            }

            Spacer(modifier = Modifier.height(18.dp))

            // Sacred Mantra & Blessing Card
            Surface(
                shape = RoundedCornerShape(22.dp),
                color = Color(0xFF172D5E).copy(alpha = 0.88f),
                border = BorderStroke(1.dp, SacredGold.copy(alpha = 0.45f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "ॐ नमो भगवते वासुदेवाय",
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        color = Color(0xFFFFE082),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "शान्ताकारं भुजगशयनं पद्मनाभं सुरेशम्।\nविश्वाधारं गगनसदृशं मेघवर्णं शुभाङ्गम्॥",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Medium
                        ),
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = when (language) {
                            AppLanguage.HINDI -> "संकट की घड़ी में धैर्य और शांति बनाए रखें — भगवान विष्णु सदैव आपकी रक्षा करें। जरूरत पड़ने पर नीचे 112 आपातकालीन सहायता पर तुरंत कॉल करें।"
                            AppLanguage.ENGLISH -> "Stay calm and steady during any crisis — may Lord Vishnu guard you and your family. Immediate 24x7 emergency aid is always one tap away."
                            AppLanguage.BILINGUAL -> "संकट में धैर्य रखें — श्री हरि सदैव रक्षक हैं। Stay calm; emergency help is one tap away."
                        },
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(0xFFDCE6FF),
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            // Protective Quick SOS Button even on Darshan Screen
            Button(
                onClick = onCallSos,
                shape = RoundedCornerShape(18.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = EmergencyCrimson,
                    contentColor = Color.White
                ),
                contentPadding = PaddingValues(horizontal = 24.dp, vertical = 14.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("darshan_sos_call_button")
            ) {
                Icon(
                    imageVector = Icons.Rounded.Shield,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    imageVector = Icons.Rounded.Call,
                    contentDescription = stringResource(R.string.cd_call_number, "112"),
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = when (language) {
                        AppLanguage.HINDI -> "आपातकालीन SOS 112 पर कॉल करें"
                        AppLanguage.ENGLISH -> "Emergency SOS — Call 112"
                        AppLanguage.BILINGUAL -> "आपातकाल SOS • Call 112"
                    },
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
