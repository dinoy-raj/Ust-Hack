package com.dinoy.forkcast.screens.listing.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dinoy.forkcast.models.ForkCastState
import com.dinoy.forkcast.screens.listing.data.models.ListingState
import com.dinoy.forkcast.screens.listing.data.models.ProductData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class ProductListingViewModel @Inject constructor() : ViewModel() {

    var state by mutableStateOf<ListingState>(ListingState())
    val productData = mutableStateListOf<ProductData>(ProductData())

    init {
        fetchProductsQuery()
    }

    fun setSelectedDate(date: LocalDate) {
        state = state.copy(
            selectedDate = date,
            queryState = ForkCastState.Loading
        )
        fetchProductsQuery()
    }


    fun fetchProductsQuery() = viewModelScope.launch {
        state = state.copy(
            queryState = ForkCastState.Loading
        )

    }


}