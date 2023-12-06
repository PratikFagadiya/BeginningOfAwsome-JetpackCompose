package com.patrikcodes.beginningofawsome.ui.navigation

sealed class AppScreen(val route: String) {

    object HomeScreen : AppScreen("HomeScreen")

    object SwitchScreen : AppScreen("SwitchScreen")
}
