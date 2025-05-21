package com.dinoy.forkcast.models

sealed class ForkCastState {
    data object Loading: ForkCastState()
    data object Success: ForkCastState()
    data object NetworkError: ForkCastState()
    data object ServerError: ForkCastState()
    data object NoResult: ForkCastState()
}