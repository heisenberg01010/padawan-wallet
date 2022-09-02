package com.goldenraven.padawanwallet.utils

import com.goldenraven.padawanwallet.R
import com.goldenraven.padawanwallet.ui.Screen

sealed class NavigationItem(val route: String, val icon_filled: Int, val icon_outline: Int, val title: String) {
    object Home : NavigationItem(route = Screen.WalletScreen.route, icon_filled = R.drawable.ic_hicon_wallet, icon_outline = R.drawable.ic_hicon_wallet, title = "Wallet")
    object Tutorial : NavigationItem(route = Screen.TutorialsHomeScreen.route, icon_filled = R.drawable.ic_hicon_education, icon_outline = R.drawable.ic_hicon_education, title = "Learn")
    object Settings : NavigationItem(route = Screen.SettingsScreen.route, icon_filled = R.drawable.ic_hicon_menu, icon_outline = R.drawable.ic_hicon_menu, title = "Menu")
}
