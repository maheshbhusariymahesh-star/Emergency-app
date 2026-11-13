package com.example.data

import com.example.model.EmergencyCategory
import com.example.model.EmergencyNumber
import com.example.model.HelplineIconType
import com.example.model.SafetyGuide

object EmergencyDirectory {

    val numbers: List<EmergencyNumber> = listOf(
        EmergencyNumber(
            id = "sos_112",
            number = "112",
            titleEn = "National Emergency Number",
            titleHi = "राष्ट्रीय आपातकालीन नंबर (ERSS)",
            descriptionEn = "Unified emergency response for Police, Fire, and Ambulance across India.",
            descriptionHi = "पूरे भारत में पुलिस, फायर ब्रिगेड और एम्बुलेंस के लिए एकीकृत आपातकालीन सहायता।",
            category = EmergencyCategory.SOS,
            iconType = HelplineIconType.SOS,
            isPrimarySos = true,
            keywords = "sos emergency police fire ambulance all in one madad"
        ),
        EmergencyNumber(
            id = "police_100",
            number = "100",
            titleEn = "Police Control Room",
            titleHi = "पुलिस कंट्रोल रूम",
            descriptionEn = "Immediate police assistance for crime, theft, law and order, or threats.",
            descriptionHi = "अपराध, चोरी, झगड़ा या सुरक्षा संकट में तुरंत पुलिस सहायता।",
            category = EmergencyCategory.SOS,
            iconType = HelplineIconType.POLICE,
            isPrimarySos = true,
            keywords = "police thana crime security chor"
        ),
        EmergencyNumber(
            id = "fire_101",
            number = "101",
            titleEn = "Fire Brigade",
            titleHi = "दमकल / अग्निशमन सेवा",
            descriptionEn = "Fire emergencies, smoke rescue, building collapse, and hazard response.",
            descriptionHi = "आग लगने, धुएं या आपात बचाव कार्य के लिए तुरंत फायर ब्रिगेड बुलाएं।",
            category = EmergencyCategory.SOS,
            iconType = HelplineIconType.FIRE,
            isPrimarySos = true,
            keywords = "fire aag damkal brigade rescue"
        ),
        EmergencyNumber(
            id = "ambulance_108",
            number = "108",
            titleEn = "Emergency Medical & Trauma",
            titleHi = "आपातकालीन एम्बुलेंस (108)",
            descriptionEn = "Free emergency medical ambulance for accidents, cardiac arrest, and trauma.",
            descriptionHi = "दुर्घटना, गंभीर बीमारी या हार्ट अटैक में निःशुल्क आपातकालीन एम्बुलेंस।",
            category = EmergencyCategory.SOS,
            iconType = HelplineIconType.AMBULANCE,
            isPrimarySos = true,
            keywords = "ambulance hospital doctor heart attack accident medical"
        ),
        EmergencyNumber(
            id = "ambulance_102",
            number = "102",
            titleEn = "Maternity & Child Ambulance",
            titleHi = "जननी व शिशु एम्बुलेंस",
            descriptionEn = "Dedicated free ambulance service for pregnant women and newborn infants.",
            descriptionHi = "गर्भवती महिलाओं और नवजात शिशुओं के लिए समर्पित निःशुल्क एम्बुलेंस।",
            category = EmergencyCategory.MEDICAL,
            iconType = HelplineIconType.AMBULANCE,
            keywords = "pregnancy maternity baby child ambulance hospital"
        ),
        EmergencyNumber(
            id = "women_1091",
            number = "1091",
            titleEn = "Women Helpline (Police)",
            titleHi = "महिला हेल्पलाइन (पुलिस)",
            descriptionEn = "Immediate police protection for women facing harassment or danger.",
            descriptionHi = "छेड़छाड़, खतरे या संकट की स्थिति में महिलाओं के लिए त्वरित पुलिस मदद।",
            category = EmergencyCategory.POLICE_SAFETY,
            iconType = HelplineIconType.WOMEN,
            keywords = "women mahila safety ladies harassment police"
        ),
        EmergencyNumber(
            id = "women_181",
            number = "181",
            titleEn = "Women Domestic Abuse Helpline",
            titleHi = "महिला सुरक्षा व घरेलू हिंसा",
            descriptionEn = "24-hour support, counseling, and rescue for women facing violence.",
            descriptionHi = "घरेलू हिंसा से पीड़ित महिलाओं के लिए 24 घंटे परामर्श और सहायता।",
            category = EmergencyCategory.POLICE_SAFETY,
            iconType = HelplineIconType.WOMEN,
            keywords = "women domestic violence abuse mahila 181"
        ),
        EmergencyNumber(
            id = "child_1098",
            number = "1098",
            titleEn = "Childline Emergency",
            titleHi = "चाइल्ड हेल्पलाइन (बच्चों की सुरक्षा)",
            descriptionEn = "Protection and rescue for lost, abused, or distressed children.",
            descriptionHi = "खोए हुए, असहाय या संकट में फंसे बच्चों की मदद और बचाव के लिए।",
            category = EmergencyCategory.POLICE_SAFETY,
            iconType = HelplineIconType.CHILD,
            keywords = "child kid bachcha lost missing abuse 1098"
        ),
        EmergencyNumber(
            id = "senior_14567",
            number = "14567",
            titleEn = "Senior Citizen Elder Line",
            titleHi = "वरिष्ठ नागरिक हेल्पलाइन",
            descriptionEn = "Free guidance, emotional support, and protection for elderly citizens.",
            descriptionHi = "बुजुर्गों के लिए निःशुल्क देखभाल, कानूनी मार्गदर्शन और सुरक्षा सहायता।",
            category = EmergencyCategory.POLICE_SAFETY,
            iconType = HelplineIconType.SENIOR,
            badgeEn = "8 AM - 8 PM Free",
            badgeHi = "सुबह 8 - रात 8 निःशुल्क",
            keywords = "senior citizen elder old age bujurg parents"
        ),
        EmergencyNumber(
            id = "health_104",
            number = "104",
            titleEn = "Medical Advice & Health",
            titleHi = "स्वास्थ्य व डॉक्टर सलाह",
            descriptionEn = "24x7 medical consultation, fever/symptom guidance, and health queries.",
            descriptionHi = "24 घंटे डॉक्टर से स्वास्थ्य सलाह, दवा और प्राथमिक उपचार जानकारी।",
            category = EmergencyCategory.MEDICAL,
            iconType = HelplineIconType.MEDICAL,
            keywords = "health doctor medicine fever dawai ilaj"
        ),
        EmergencyNumber(
            id = "mental_14416",
            number = "14416",
            titleEn = "Tele-MANAS Mental Health",
            titleHi = "मानसिक स्वास्थ्य सहायता (Tele-MANAS)",
            descriptionEn = "Confidential 24x7 counseling for stress, anxiety, depression, or crisis.",
            descriptionHi = "तनाव, चिंता या मानसिक संकट में गोपनीय 24x7 विशेषज्ञ परामर्श।",
            category = EmergencyCategory.MEDICAL,
            iconType = HelplineIconType.MENTAL_HEALTH,
            keywords = "mental health stress depression anxiety suicide counseling"
        ),
        EmergencyNumber(
            id = "blood_1910",
            number = "1910",
            titleEn = "Blood Bank Helpline",
            titleHi = "ब्लड बैंक जानकारी",
            descriptionEn = "Check blood group availability and locate nearby blood banks quickly.",
            descriptionHi = "नजदीकी ब्लड बैंक और रक्त समूह की उपलब्धता की तुरंत जानकारी।",
            category = EmergencyCategory.MEDICAL,
            iconType = HelplineIconType.BLOOD,
            keywords = "blood bank khoon plasma donor hospital"
        ),
        EmergencyNumber(
            id = "health_1075",
            number = "1075",
            titleEn = "National Health Helpline",
            titleHi = "राष्ट्रीय स्वास्थ्य मंत्रालय हेल्पलाइन",
            descriptionEn = "Ministry of Health infectious disease & public health advisory.",
            descriptionHi = "स्वास्थ्य मंत्रालय की जन-स्वास्थ्य व रोग नियंत्रण सूचना सेवा।",
            category = EmergencyCategory.MEDICAL,
            iconType = HelplineIconType.MEDICAL,
            keywords = "health ministry disease epidemic medical"
        ),
        EmergencyNumber(
            id = "road_1073",
            number = "1073",
            titleEn = "Road Accident Emergency",
            titleHi = "सड़क दुर्घटना सहायता",
            descriptionEn = "Rapid road accident trauma response and traffic police dispatch.",
            descriptionHi = "सड़क हादसे में तुरंत एम्बुलेंस और ट्रैफिक पुलिस सहायता।",
            category = EmergencyCategory.TRAVEL_DISASTER,
            iconType = HelplineIconType.ROAD,
            keywords = "road accident traffic crash car bike"
        ),
        EmergencyNumber(
            id = "highway_1033",
            number = "1033",
            titleEn = "National Highway Helpline (NHAI)",
            titleHi = "राष्ट्रीय राजमार्ग सहायता (NHAI)",
            descriptionEn = "24x7 highway patrol, ambulance, crane/towing, and breakdown aid.",
            descriptionHi = "हाईवे पर दुर्घटना, वाहन खराबी या क्रेन/एम्बुलेंस सहायता।",
            category = EmergencyCategory.TRAVEL_DISASTER,
            iconType = HelplineIconType.HIGHWAY,
            keywords = "highway nhai expressway car breakdown towing"
        ),
        EmergencyNumber(
            id = "rail_139",
            number = "139",
            titleEn = "Railway Emergency & Inquiry",
            titleHi = "रेलवे सहायता व शिकायत (Rail Madad)",
            descriptionEn = "Medical help on train, passenger security, and railway inquiries.",
            descriptionHi = "ट्रेन में मेडिकल मदद, सुरक्षा और रेलवे यात्रा सहायता।",
            category = EmergencyCategory.TRAVEL_DISASTER,
            iconType = HelplineIconType.RAILWAY,
            keywords = "railway train station irctc ticket security"
        ),
        EmergencyNumber(
            id = "rpf_182",
            number = "182",
            titleEn = "Railway Protection Force (RPF)",
            titleHi = "रेलवे सुरक्षा बल (RPF)",
            descriptionEn = "Report theft, harassment, or suspicious activity on trains/stations.",
            descriptionHi = "ट्रेन या स्टेशन पर चोरी, छेड़छाड़ या सुरक्षा खतरे की सूचना।",
            category = EmergencyCategory.TRAVEL_DISASTER,
            iconType = HelplineIconType.RAILWAY,
            keywords = "rpf railway police train theft"
        ),
        EmergencyNumber(
            id = "disaster_1070",
            number = "1070",
            titleEn = "State Disaster Management",
            titleHi = "राज्य आपदा प्रबंधन (बाढ़ / भूकंप)",
            descriptionEn = "Floods, earthquakes, cyclones, and state-level disaster relief.",
            descriptionHi = "बाढ़, भूकंप, तूफान या प्राकृतिक आपदा में राहत व बचाव सहायता।",
            category = EmergencyCategory.TRAVEL_DISASTER,
            iconType = HelplineIconType.DISASTER,
            keywords = "disaster flood earthquake storm relief badh bhukamp"
        ),
        EmergencyNumber(
            id = "ndrf_1078",
            number = "1078",
            titleEn = "National Disaster (NDMA)",
            titleHi = "राष्ट्रीय आपदा सहायता (NDMA)",
            descriptionEn = "National disaster response coordination for severe calamities.",
            descriptionHi = "गंभीर प्राकृतिक आपदाओं में राष्ट्रीय आपदा मोचन सहायता।",
            category = EmergencyCategory.TRAVEL_DISASTER,
            iconType = HelplineIconType.DISASTER,
            keywords = "ndrf ndma disaster rescue calamity"
        ),
        EmergencyNumber(
            id = "tourist_1363",
            number = "1363",
            titleEn = "Tourist Helpline",
            titleHi = "पर्यटक हेल्पलाइन (24x7)",
            descriptionEn = "Multilingual emergency and travel assistance for tourists in India.",
            descriptionHi = "यात्रियों व पर्यटकों के लिए बहुभाषी आपातकालीन और यात्रा सहायता।",
            category = EmergencyCategory.TRAVEL_DISASTER,
            iconType = HelplineIconType.TOURIST,
            keywords = "tourist travel yatra visitor helpline"
        ),
        EmergencyNumber(
            id = "cyber_1930",
            number = "1930",
            titleEn = "Cyber Crime & UPI Fraud",
            titleHi = "साइबर क्राइम व ऑनलाइन धोखाधड़ी",
            descriptionEn = "Call immediately to freeze stolen funds in UPI, banking, or online scams.",
            descriptionHi = "UPI, बैंक या ऑनलाइन ठगी होने पर पैसे रोकने के लिए तुरंत कॉल करें।",
            category = EmergencyCategory.CIVIC_CYBER,
            iconType = HelplineIconType.CYBER,
            keywords = "cyber crime fraud upi bank scam online otp hack"
        ),
        EmergencyNumber(
            id = "lpg_1906",
            number = "1906",
            titleEn = "LPG Gas Leakage Emergency",
            titleHi = "एलपीजी गैस रिसाव आपातकाल",
            descriptionEn = "Urgent response for cooking gas cylinder leak or smell at home.",
            descriptionHi = "रसोई गैस सिलेंडर से रिसाव या गंध आने पर तुरंत आपात सहायता।",
            category = EmergencyCategory.CIVIC_CYBER,
            iconType = HelplineIconType.GAS,
            keywords = "gas leak lpg cylinder kitchen fire indane hp bharat"
        ),
        EmergencyNumber(
            id = "electricity_1912",
            number = "1912",
            titleEn = "Electricity & Power Fault",
            titleHi = "बिजली आपातकाल व शिकायत",
            descriptionEn = "Report fallen electric wires, transformer sparks, or power outage.",
            descriptionHi = "बिजली का तार टूटने, शॉर्ट सर्किट या बिजली गुल होने की सूचना।",
            category = EmergencyCategory.CIVIC_CYBER,
            iconType = HelplineIconType.ELECTRICITY,
            keywords = "electricity power bijli wire short circuit current"
        ),
        EmergencyNumber(
            id = "kisan_1551",
            number = "1551",
            titleEn = "Kisan Call Centre",
            titleHi = "किसान कॉल सेंटर",
            descriptionEn = "Agricultural guidance, weather alerts, and crop support for farmers.",
            descriptionHi = "किसानों के लिए खेती, मौसम चेतावनी और फसल सुरक्षा मार्गदर्शन।",
            category = EmergencyCategory.CIVIC_CYBER,
            iconType = HelplineIconType.FARMER,
            badgeEn = "6 AM - 10 PM Free",
            badgeHi = "सुबह 6 - रात 10 निःशुल्क",
            keywords = "kisan farmer agriculture crop fasal"
        ),
        EmergencyNumber(
            id = "anticorruption_1031",
            number = "1031",
            titleEn = "Anti-Corruption Helpline",
            titleHi = "भ्रष्टाचार निरोधक हेल्पलाइन",
            descriptionEn = "Report bribery demands or corruption in public services.",
            descriptionHi = "सरकारी कार्य में रिश्वतखोरी या भ्रष्टाचार की शिकायत दर्ज करें।",
            category = EmergencyCategory.CIVIC_CYBER,
            iconType = HelplineIconType.CORRUPTION,
            keywords = "corruption bribe rishwat complaint vigilance"
        )
    )

    val safetyGuides: List<SafetyGuide> = listOf(
        SafetyGuide(
            id = "guide_medical",
            titleEn = "Medical Emergency & Unconsciousness",
            titleHi = "चिकित्सा आपातकाल और बेहोशी",
            summaryEn = "Immediate actions before the 108 ambulance arrives.",
            summaryHi = "108 एम्बुलेंस आने से पहले करने योग्य जरूरी कदम।",
            stepsEn = listOf(
                "Call 108 or 112 immediately and share exact landmark/location.",
                "Check breathing; lay the person flat on a firm surface or recovery side if breathing.",
                "Do not crowd around the patient; loosen tight clothing around neck and chest.",
                "Never give water or food to an unconscious or semi-conscious person."
            ),
            stepsHi = listOf(
                "तुरंत 108 या 112 पर कॉल करें और सही पता व नजदीकी लैंडमार्क बताएं।",
                "सांस जांचें; यदि सांस चल रही है तो करवट से लिटाएं (Recovery Position)।",
                "मरीज के पास भीड़ न लगाएं और गले व छाती के पास के कपड़े ढीले करें।",
                "बेहोश व्यक्ति को कभी भी पानी या कुछ खाने को न दें।"
            ),
            primaryNumber = "108",
            primaryNumberLabelEn = "Call 108 Ambulance",
            primaryNumberLabelHi = "108 एम्बुलेंस बुलाएं",
            category = EmergencyCategory.MEDICAL
        ),
        SafetyGuide(
            id = "guide_cyber",
            titleEn = "Online / UPI Financial Fraud",
            titleHi = "ऑनलाइन या UPI धोखाधड़ी होने पर",
            summaryEn = "The Golden Hour: act within minutes to freeze stolen funds.",
            summaryHi = "गोल्डन आवर: पैसे वापस पाने के लिए तुरंत कदम उठाएं।",
            stepsEn = listOf(
                "Call 1930 immediately within the first 1-2 hours of the transaction.",
                "Keep Transaction ID (UTR), bank name, and fraudster's phone/UPI ID ready.",
                "Block your debit/credit card or freeze UPI via your bank app.",
                "File the formal complaint on cybercrime.gov.in after the 1930 call."
            ),
            stepsHi = listOf(
                "ठगी के 1-2 घंटे के भीतर तुरंत 1930 पर कॉल करें।",
                "लेनदेन की Transaction ID (UTR), बैंक का नाम और ठग का नंबर/UPI ID तैयार रखें।",
                "तुरंत अपने बैंक ऐप से डेबिट/क्रेडिट कार्ड या UPI ब्लॉक करें।",
                "1930 पर कॉल करने के बाद cybercrime.gov.in पर शिकायत दर्ज करें।"
            ),
            primaryNumber = "1930",
            primaryNumberLabelEn = "Call 1930 Cyber Helpline",
            primaryNumberLabelHi = "1930 साइबर हेल्पलाइन",
            category = EmergencyCategory.CIVIC_CYBER
        ),
        SafetyGuide(
            id = "guide_gas",
            titleEn = "LPG Gas Leak at Home",
            titleHi = "घर में गैस रिसाव होने पर",
            summaryEn = "Prevent sparks and ventilate immediately.",
            summaryHi = "चिंगारी से बचें और तुरंत हवादार बनाएं।",
            stepsEn = listOf(
                "Do NOT switch ON or OFF any electric light, fan, or matchstick.",
                "Open all doors and windows immediately for cross-ventilation.",
                "Turn off the gas regulator knob and take the cylinder to an open area if safe.",
                "Step outside and call 1906 (LPG Emergency) or 101 (Fire)."
            ),
            stepsHi = listOf(
                "बिजली का कोई भी स्विच (लाइट/पंखा) चालू या बंद न करें, माचिस न जलाएं।",
                "तुरंत घर के सभी दरवाजे और खिड़कियां खोल दें।",
                "गैस रेगुलेटर बंद करें और सुरक्षित हो तो सिलेंडर को खुली हवा में रखें।",
                "घर से बाहर निकलकर 1906 (गैस हेल्पलाइन) या 101 (दमकल) पर कॉल करें।"
            ),
            primaryNumber = "1906",
            primaryNumberLabelEn = "Call 1906 Gas Helpline",
            primaryNumberLabelHi = "1906 गैस हेल्पलाइन",
            category = EmergencyCategory.CIVIC_CYBER
        ),
        SafetyGuide(
            id = "guide_fire",
            titleEn = "Fire Safety & Evacuation",
            titleHi = "आग लगने पर बचाव के नियम",
            summaryEn = "Stay low, evacuate fast, never use elevators.",
            summaryHi = "नीचे झुककर निकलें और लिफ्ट का उपयोग न करें।",
            stepsEn = listOf(
                "Alert everyone around and dial 101 or 112 immediately.",
                "Always use stairs, NEVER use an elevator during a fire.",
                "If there is thick smoke, crawl low under the smoke and cover nose with wet cloth.",
                "If clothes catch fire: Stop, Drop to the ground, and Roll to smother flames."
            ),
            stepsHi = listOf(
                "सभी को सचेत करें और तुरंत 101 या 112 पर कॉल करें।",
                "बाहर निकलने के लिए केवल सीढ़ियों का उपयोग करें, लिफ्ट बिल्कुल न लें।",
                "धुआं होने पर जमीन के करीब झुककर निकलें और मुंह पर गीला कपड़ा रखें।",
                "कपड़ों में आग लगने पर भागें नहीं — रुकें, जमीन पर लेटें और लुढ़कें।"
            ),
            primaryNumber = "101",
            primaryNumberLabelEn = "Call 101 Fire Brigade",
            primaryNumberLabelHi = "101 दमकल बुलाएं",
            category = EmergencyCategory.SOS
        ),
        SafetyGuide(
            id = "guide_road",
            titleEn = "Road & Highway Accident",
            titleHi = "सड़क दुर्घटना सहायता",
            summaryEn = "Good Samaritan protection keeps helpers safe legally.",
            summaryHi = "सड़क हादसे में मदद करने वालों को कानूनन सुरक्षा प्राप्त है।",
            stepsEn = listOf(
                "Park safely with hazard lights ON; place warning triangle if available.",
                "Call 1073 (Road Accident), 1033 (Highway), or 112 right away.",
                "Do not pull out trapped victims abruptly unless there is immediate fire risk.",
                "Keep injured person calm and wait for paramedics."
            ),
            stepsHi = listOf(
                "अपना वाहन सुरक्षित किनारे पार्किंग लाइट जलाकर खड़ा करें।",
                "तुरंत 1073 (सड़क दुर्घटना), 1033 (हाईवे) या 112 पर कॉल करें।",
                "जब तक आग का खतरा न हो, फंसे हुए घायल व्यक्ति को झटके से न खींचें।",
                "घायल व्यक्ति को शांत रखें और मेडिकल टीम के आने का इंतजार करें।"
            ),
            primaryNumber = "1073",
            primaryNumberLabelEn = "Call 1073 Road Accident",
            primaryNumberLabelHi = "1073 दुर्घटना सहायता",
            category = EmergencyCategory.TRAVEL_DISASTER
        )
    )
}
