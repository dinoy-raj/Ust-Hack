package com.dinoy.forkcast.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dinoy.forkcast.home.HomeScreen

@Composable
fun MainNavigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
        startDestination = InnerRoutes.Home
    ) {
        composable<InnerRoutes.Home> {
            HomeScreen()
        }
        composable<InnerRoutes.FileUpload> {}
        composable<InnerRoutes.Details> {}
    }
}