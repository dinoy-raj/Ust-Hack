package com.dinoy.forkcast.home

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
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

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun HomeNavigation(
    modifier: Modifier = Modifier,
    controller: NavHostController,
    animatedVisibilityScope: AnimatedContentScope,
    sharedTransitionScope: SharedTransitionScope,
    onNavigate: (Any) -> Unit
) {
    NavHost(
        modifier = modifier,
        navController = controller,
        startDestination = MainRoute.Landing,
    ) {
        composable<MainRoute.Landing> {
            LandingScreen(controller)
        }

        composable<MainRoute.Listing> {
            ProductListingScreen(
                animatedVisibilityScope = animatedVisibilityScope,
                sharedTransitionScope = sharedTransitionScope
            )
            {
                onNavigate(it)
            }
        }

        composable<MainRoute.Upload> {
            UploadScreen()
        }

        composable<MainRoute.Profile> {
            ProfileScreen()
        }
    }
}