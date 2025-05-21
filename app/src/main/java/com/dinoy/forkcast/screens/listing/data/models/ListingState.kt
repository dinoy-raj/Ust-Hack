package com.dinoy.forkcast.screens.listing.data.models

import com.dinoy.forkcast.models.ForkCastState
import java.time.LocalDate

data class ListingState(
    val queryState: ForkCastState = ForkCastState.Loading,
    val selectedDate: LocalDate = LocalDate.now()
)
