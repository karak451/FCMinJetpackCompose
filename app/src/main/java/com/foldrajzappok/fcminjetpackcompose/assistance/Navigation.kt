package com.foldrajzappok.fcminjetpackcompose.assistance

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.foldrajzappok.fcminjetpackcompose.model.AuthViewModel
import com.foldrajzappok.fcminjetpackcompose.screens.StartScreen

@Composable
fun Navigation(
    avm: AuthViewModel
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "StartScreen"
    ) {

        composable(
            route = "StartScreen"
        ) {
            StartScreen(
                navController,
                avm
            )
        }

    }
}