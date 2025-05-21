package com.dinoy.forkcast.navigation

import com.dinoy.forkcast.R
import com.dinoy.forkcast.models.NavTabs
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.LocalDate

object MainRoute {

    @Serializable
    data object Landing

    @Serializable
    data object Listing

    @Serializable
    data object Upload

    @Serializable
    data object Profile
}

object InnerRoutes {

    @Serializable
    data object Home

    @Serializable
    data object FileUpload

    @Serializable
    data class Details(val product: String, val date: String)

}


object NavMetaData {
    val navTabs = listOf<NavTabs>(
        NavTabs(
            nameId = R.string.discover,
            selectedIcon = R.drawable.explore_active,
            unSelectedIcon = R.drawable.explore
        ),
        NavTabs(
            nameId = R.string.inventories,
            selectedIcon = R.drawable.price_hike,
            unSelectedIcon = R.drawable.price_hike
        ),
        NavTabs(
            nameId = R.string.history,
            selectedIcon = R.drawable.approvals_filled,
            unSelectedIcon = R.drawable.approvals
        ),
        NavTabs(
            nameId = R.string.profile,
            selectedIcon = R.drawable.user_filled,
            unSelectedIcon = R.drawable.user
        )
    )


    val RootRoutes =
        arrayOf(
            MainRoute.Landing,
            MainRoute.Listing,
            MainRoute.Upload,
            MainRoute.Profile
        )
}
