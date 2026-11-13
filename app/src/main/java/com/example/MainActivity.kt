package com.example

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AutoAwesome
import androidx.compose.material.icons.outlined.HealthAndSafety
import androidx.compose.material.icons.outlined.Sos
import androidx.compose.material.icons.rounded.AutoAwesome
import androidx.compose.material.icons.rounded.HealthAndSafety
import androidx.compose.material.icons.rounded.Sos
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.data.PreferencesRepository
import com.example.model.AppLanguage
import com.example.model.AppTab
import com.example.model.EmergencyNumber
import com.example.ui.EmergencyViewModel
import com.example.ui.screens.EmergencyDirectoryScreen
import com.example.ui.screens.SafetyGuideScreen
import com.example.ui.screens.VishnuDarshanScreen
import com.example.ui.theme.VishnuRakshaTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val preferencesRepository = PreferencesRepository(applicationContext)
        setContent {
            VishnuRakshaTheme {
                val viewModel: EmergencyViewModel = viewModel(
                    factory = EmergencyViewModel.Factory(preferencesRepository)
                )
                VishnuRakshaApp(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun VishnuRakshaApp(viewModel: EmergencyViewModel) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    fun copyToClipboard(number: String, label: String) {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as? ClipboardManager
        clipboard?.setPrimaryClip(ClipData.newPlainText("Emergency Number", number))
        coroutineScope.launch {
            snackbarHostState.showSnackbar(
                context.getString(R.string.copied_snackbar, number, label)
            )
        }
    }

    fun dialNumber(number: String) {
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
        try {
            context.startActivity(intent)
        } catch (_: Exception) {
            val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as? ClipboardManager
            clipboard?.setPrimaryClip(ClipData.newPlainText("Emergency Number", number))
            coroutineScope.launch {
                snackbarHostState.showSnackbar(
                    context.getString(R.string.dialer_unavailable_snackbar, number)
                )
            }
        }
    }

    fun shareHelpline(item: EmergencyNumber) {
        val shareText = "${item.titleHi} (${item.titleEn}): ${item.number}\n${item.descriptionHi}"
        val sendIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, shareText)
        }
        val chooser = Intent.createChooser(
            sendIntent,
            context.getString(R.string.share_chooser_title)
        )
        runCatching { context.startActivity(chooser) }
    }

    if (uiState.selectedTab != AppTab.DIRECTORY && !uiState.isFullDarshanOpen) {
        BackHandler {
            viewModel.selectTab(AppTab.DIRECTORY)
        }
    }

    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val useNavigationRail = maxWidth >= 600.dp

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            contentWindowInsets = WindowInsets.safeDrawing,
            snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
            bottomBar = {
                if (!useNavigationRail) {
                    NavigationBar(
                        containerColor = MaterialTheme.colorScheme.surface
                    ) {
                        AppTab.entries.forEach { tab ->
                            val selected = uiState.selectedTab == tab
                            NavigationBarItem(
                                selected = selected,
                                onClick = { viewModel.selectTab(tab) },
                                icon = {
                                    Icon(
                                        imageVector = tabIcon(tab, selected),
                                        contentDescription = tabLabel(tab, uiState.language)
                                    )
                                },
                                label = {
                                    Text(text = tabLabel(tab, uiState.language))
                                },
                                modifier = Modifier.testTag("nav_tab_${tab.name.lowercase()}")
                            )
                        }
                    }
                }
            }
        ) { innerPadding ->
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                if (useNavigationRail) {
                    NavigationRail(
                        modifier = Modifier.fillMaxHeight(),
                        containerColor = MaterialTheme.colorScheme.surface
                    ) {
                        Spacer(modifier = Modifier.weight(1f))
                        AppTab.entries.forEach { tab ->
                            val selected = uiState.selectedTab == tab
                            NavigationRailItem(
                                selected = selected,
                                onClick = { viewModel.selectTab(tab) },
                                icon = {
                                    Icon(
                                        imageVector = tabIcon(tab, selected),
                                        contentDescription = tabLabel(tab, uiState.language)
                                    )
                                },
                                label = {
                                    Text(text = tabLabel(tab, uiState.language))
                                },
                                modifier = Modifier.testTag("rail_tab_${tab.name.lowercase()}")
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }

                Box(modifier = Modifier.weight(1f)) {
                    when (uiState.selectedTab) {
                        AppTab.DIRECTORY -> {
                            EmergencyDirectoryScreen(
                                uiState = uiState,
                                onSearchQueryChange = viewModel::updateSearchQuery,
                                onSelectCategory = viewModel::selectCategory,
                                onResetFilters = viewModel::resetFilters,
                                onCallNumber = ::dialNumber,
                                onCopyNumber = { item ->
                                    val label = if (uiState.language == AppLanguage.ENGLISH) {
                                        item.titleEn
                                    } else {
                                        item.titleHi
                                    }
                                    copyToClipboard(item.number, label)
                                },
                                onShareNumber = ::shareHelpline,
                                onTogglePin = viewModel::togglePin,
                                onCycleLanguage = viewModel::cycleLanguage,
                                onOpenFullDarshan = { viewModel.setFullDarshanOpen(true) }
                            )
                        }

                        AppTab.DARSHAN -> {
                            VishnuDarshanScreen(
                                language = uiState.language,
                                onCallSos = { dialNumber("112") }
                            )
                        }

                        AppTab.SAFETY -> {
                            SafetyGuideScreen(
                                guides = uiState.safetyGuides,
                                language = uiState.language,
                                onCallNumber = ::dialNumber
                            )
                        }
                    }
                }
            }
        }
    }

    if (uiState.isFullDarshanOpen) {
        Dialog(
            onDismissRequest = { viewModel.setFullDarshanOpen(false) },
            properties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            BackHandler {
                viewModel.setFullDarshanOpen(false)
            }
            VishnuDarshanScreen(
                language = uiState.language,
                onCallSos = {
                    viewModel.setFullDarshanOpen(false)
                    dialNumber("112")
                },
                onCloseModal = { viewModel.setFullDarshanOpen(false) }
            )
        }
    }
}

private fun tabIcon(tab: AppTab, selected: Boolean) = when (tab) {
    AppTab.DIRECTORY -> if (selected) Icons.Rounded.Sos else Icons.Outlined.Sos
    AppTab.DARSHAN -> if (selected) Icons.Rounded.AutoAwesome else Icons.Outlined.AutoAwesome
    AppTab.SAFETY -> if (selected) Icons.Rounded.HealthAndSafety else Icons.Outlined.HealthAndSafety
}

@Composable
private fun tabLabel(tab: AppTab, language: AppLanguage): String = when (tab) {
    AppTab.DIRECTORY -> when (language) {
        AppLanguage.HINDI -> "आपातकाल"
        AppLanguage.ENGLISH -> stringResource(R.string.nav_emergency)
        AppLanguage.BILINGUAL -> "आपातकाल"
    }
    AppTab.DARSHAN -> when (language) {
        AppLanguage.HINDI -> "विष्णु दर्शन"
        AppLanguage.ENGLISH -> stringResource(R.string.nav_darshan)
        AppLanguage.BILINGUAL -> "दर्शन"
    }
    AppTab.SAFETY -> when (language) {
        AppLanguage.HINDI -> "सुरक्षा गाइड"
        AppLanguage.ENGLISH -> stringResource(R.string.nav_safety)
        AppLanguage.BILINGUAL -> "गाइड"
    }
}
