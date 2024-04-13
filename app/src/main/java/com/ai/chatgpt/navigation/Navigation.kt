package com.ai.chatgpt.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ai.chatgpt.screens.HomeScreen
import com.ai.chatgpt.screens.SplashScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavScreens.SplashScreen.name
    ) {
        composable(NavScreens.SplashScreen.name) {
            SplashScreen(navController = navController)
        }
        composable(NavScreens.HomeScreen.name) {
            HomeScreen()
        }
    }
}