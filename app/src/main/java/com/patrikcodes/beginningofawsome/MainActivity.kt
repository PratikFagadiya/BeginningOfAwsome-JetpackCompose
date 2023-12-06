package com.patrikcodes.beginningofawsome

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.patrikcodes.beginningofawsome.ui.navigation.AppNavHost
import com.patrikcodes.beginningofawsome.ui.theme.BeginningOfAwsomeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeginningOfAwsomeTheme {
                // A surface container using the 'background' color from the theme

                val navController = rememberNavController()

                AppNavHost(navController)
            }

        }
    }
}

