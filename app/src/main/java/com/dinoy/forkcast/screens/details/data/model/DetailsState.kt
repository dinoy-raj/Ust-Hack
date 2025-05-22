package com.dinoy.forkcast.screens.details.data.model

import com.dinoy.forkcast.models.ForkCastState
import com.dinoy.forkcast.screens.listing.data.models.ProductCategory
import java.time.LocalDate

data class DetailsState(
    val queryState: ForkCastState = ForkCastState.Loading,
    val selectedDate: LocalDate = LocalDate.now(),
    val selectedCategory: ProductCategory = ProductCategory.Soup,
    val average: Double = 0.0
)
