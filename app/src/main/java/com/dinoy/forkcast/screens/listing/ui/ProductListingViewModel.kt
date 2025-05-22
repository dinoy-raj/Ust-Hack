package com.dinoy.forkcast.screens.listing.ui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dinoy.forkcast.models.ForkCastState
import com.dinoy.forkcast.network.DinoRetroFit
import com.dinoy.forkcast.screens.listing.data.models.ListingState
import com.dinoy.forkcast.screens.listing.data.models.PredictRequest
import com.dinoy.forkcast.screens.listing.data.models.ProductCategory
import com.dinoy.forkcast.screens.listing.data.models.ProductData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class ProductListingViewModel @Inject constructor() : ViewModel() {

    var state by mutableStateOf<ListingState>(ListingState())
    val productData = mutableStateListOf<ProductData>(ProductData())

    init {
        productData.clear()
        fetchProductsQuery()
    }

    fun showSnackBar(message: String) = viewModelScope.launch {
        state = state.copy(
            error = message
        )
        delay(3000)

        state = state.copy(
            error = null
        )
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
        productData.clear()

        try {
            val response = DinoRetroFit.create().getProductListingDetails(
                PredictRequest(
                    date = state.selectedDate.toString(),
                    latitude = 8.5686,
                    longitude = 76.8731
                )
            )

            productData.add(
                ProductData(
                    category = ProductCategory.Soup,
                    quantity = response.Soup_Waste_kg
                )
            )

            productData.add(
                ProductData(
                    category = ProductCategory.Salad,
                    quantity = response.Salad_Waste_kg
                )
            )

            productData.add(
                ProductData(
                    category = ProductCategory.Dessert,
                    quantity = response.Dessert_Waste_kg
                )
            )

            productData.add(
                ProductData(
                    category = ProductCategory.Beverage,
                    quantity = response.Beverage_Waste_kg
                )
            )

            productData.add(
                ProductData(
                    category = ProductCategory.Appetizer,
                    quantity = response.Appetizer_Waste_kg
                )
            )

            productData.add(
                ProductData(
                    category = ProductCategory.MainCourse,
                    quantity = response.Main_Course_Waste_kg
                )
            )

            state = state.copy(queryState = ForkCastState.Success)

        } catch (e: Exception) {
            state = state.copy(queryState = ForkCastState.ServerError)
            showSnackBar(e.message.orEmpty() + e.localizedMessage.orEmpty())
        }

    }


}