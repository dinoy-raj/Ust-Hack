package com.dinoy.forkcast.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.dinoy.forkcast.home.HomeScreen
import com.dinoy.forkcast.screens.details.ui.ProductDetailsScreen
import com.dinoy.forkcast.screens.listing.data.models.ProductCategory

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun MainNavigation() {
    val navController: NavHostController = rememberNavController()

    SharedTransitionLayout {
        NavHost(
            modifier = Modifier.fillMaxSize(),
            navController = navController,
            startDestination = InnerRoutes.Home
        ) {
            composable<InnerRoutes.Home> {
                HomeScreen(
                    animatedVisibilityScope = this,
                    sharedTransitionScope = this@SharedTransitionLayout,
                    onNavigate = { navController.navigate(it) }
                )
            }
            composable<InnerRoutes.FileUpload> {}
            composable<InnerRoutes.Details> { navBackStack ->
                val category = navBackStack.toRoute<InnerRoutes.Details>().product
                val date = navBackStack.toRoute<InnerRoutes.Details>().date
                ProductDetailsScreen(
                    category = ProductCategory.valueOf(category),
                    animatedVisibilityScope = this,
                    sharedTransitionScope = this@SharedTransitionLayout,
                    date = date,
                )
                {
                    navController.popBackStack()
                }
            }
        }
    }
}