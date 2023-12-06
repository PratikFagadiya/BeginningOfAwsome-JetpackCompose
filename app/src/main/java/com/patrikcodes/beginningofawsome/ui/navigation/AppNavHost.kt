package com.patrikcodes.beginningofawsome.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.patrikcodes.beginningofawsome.ui.presentation.switch.SwitchScreen

@Composable
fun AppNavHost(navController: NavHostController) {

    NavHost(navController = navController, startDestination = AppScreen.SwitchScreen.route) {

        composable(route = AppScreen.HomeScreen.route) {

        }

        composable(route = AppScreen.SwitchScreen.route) {
            SwitchScreen()
        }

    }

}