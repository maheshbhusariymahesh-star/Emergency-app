package com.example.model

import androidx.compose.ui.graphics.Color
import com.example.ui.theme.CyberIndigo
import com.example.ui.theme.EmergencyCrimson
import com.example.ui.theme.FireAmber
import com.example.ui.theme.MedicalEmerald
import com.example.ui.theme.PoliceBlue
import com.example.ui.theme.WomenViolet

enum class AppLanguage(val code: String, val label: String) {
    BILINGUAL("bi", "हिं / EN"),
    HINDI("hi", "हिन्दी"),
    ENGLISH("en", "EN")
}

enum class AppTab {
    DIRECTORY,
    DARSHAN,
    SAFETY
}

enum class EmergencyCategory(
    val labelEn: String,
    val labelHi: String,
    val accentColor: Color
) {
    ALL("All", "सभी", PoliceBlue),
    SOS("Core SOS", "मुख्य SOS", EmergencyCrimson),
    POLICE_SAFETY("Women & Child", "महिला / बाल", WomenViolet),
    MEDICAL("Medical", "चिकित्सा", MedicalEmerald),
    TRAVEL_DISASTER("Travel & Disaster", "यात्रा / आपदा", FireAmber),
    CIVIC_CYBER("Cyber & Civic", "साइबर / सेवा", CyberIndigo)
}

enum class HelplineIconType {
    SOS,
    POLICE,
    FIRE,
    AMBULANCE,
    WOMEN,
    CHILD,
    SENIOR,
    MEDICAL,
    MENTAL_HEALTH,
    BLOOD,
    ROAD,
    HIGHWAY,
    RAILWAY,
    DISASTER,
    CYBER,
    GAS,
    ELECTRICITY,
    FARMER,
    TOURIST,
    CORRUPTION
}

data class EmergencyNumber(
    val id: String,
    val number: String,
    val titleEn: String,
    val titleHi: String,
    val descriptionEn: String,
    val descriptionHi: String,
    val category: EmergencyCategory,
    val iconType: HelplineIconType,
    val isPrimarySos: Boolean = false,
    val badgeEn: String = "24x7 Toll-Free",
    val badgeHi: String = "24x7 निःशुल्क",
    val keywords: String = ""
)

data class SafetyGuide(
    val id: String,
    val titleEn: String,
    val titleHi: String,
    val summaryEn: String,
    val summaryHi: String,
    val stepsEn: List<String>,
    val stepsHi: List<String>,
    val primaryNumber: String,
    val primaryNumberLabelEn: String,
    val primaryNumberLabelHi: String,
    val category: EmergencyCategory
)
