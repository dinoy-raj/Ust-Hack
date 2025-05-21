package com.dinoy.forkcast.screens.details.data.model

import com.dinoy.forkcast.models.ForkCastState

data class DetailsState(
    val state: ForkCastState = ForkCastState.Loading
)
