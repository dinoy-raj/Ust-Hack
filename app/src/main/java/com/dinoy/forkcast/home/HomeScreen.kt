package com.dinoy.forkcast.home

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.dinoy.forkcast.components.DinoBottomNavigationBar
import com.dinoy.forkcast.navigation.NavMetaData
import com.dinoy.forkcast.navigation.NavMetaData.RootRoutes

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun HomeScreen(
    onNavigate: (Any) -> Unit,
    animatedVisibilityScope: AnimatedContentScope,
    sharedTransitionScope: SharedTransitionScope
) {
    val navController: NavHostController = rememberNavController()
    var selectedTab by rememberSaveable { mutableIntStateOf(0) }

    // TODO: Find another way to handle this
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentR = navBackStackEntry?.destination?.route

    LaunchedEffect(navBackStackEntry) {
        when (currentR) {
            "com.dinoy.forkcast.navigation.MainRoute.Landing" -> selectedTab = 0
            "com.dinoy.forkcast.navigation.MainRoute.Listing" -> selectedTab = 1
            "com.dinoy.forkcast.navigation.MainRoute.Upload" -> selectedTab = 2
            "com.dinoy.forkcast.navigation.MainRoute.Profile" -> selectedTab = 3
        }
    }

    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .background(color = Color.White),
    ) {

        HomeNavigation(
            modifier = Modifier.weight(1f),
            controller = navController,
            animatedVisibilityScope = animatedVisibilityScope,
            sharedTransitionScope = sharedTransitionScope
        )
        {
            onNavigate(it)
        }

        // slate bottom navigation bar
        DinoBottomNavigationBar(
            modifier = Modifier.fillMaxWidth(),
            items = NavMetaData.navTabs,
            selectedIndex = selectedTab,
            onClick = {
                selectedTab = it
                navController.run controller@{
                    navigate(
                        RootRoutes[it],
                        navOptions {
                            popUpTo(this@controller.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        },
                    )
                }
            },
        )
    }
}