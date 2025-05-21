package com.dinoy.forkcast.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dinoy.forkcast.navigation.MainRoute
import com.dinoy.forkcast.screens.UploadScreen
import com.dinoy.forkcast.screens.landing.LandingScreen
import com.dinoy.forkcast.screens.listing.ui.ProductListingScreen
import com.dinoy.forkcast.screens.profile.ui.ProfileScreen

@Composable
fun HomeNavigation(
    modifier: Modifier = Modifier,
    controller: NavHostController,
) {
    NavHost(
        modifier = modifier,
        navController = controller,
        startDestination = MainRoute.Landing,
    ) {
        composable<MainRoute.Landing> {
            LandingScreen()
        }

        composable<MainRoute.Listing> {
            ProductListingScreen()
        }

        composable<MainRoute.Upload> {
            UploadScreen()
        }

        composable<MainRoute.Profile> {
            ProfileScreen()
        }
    }
}