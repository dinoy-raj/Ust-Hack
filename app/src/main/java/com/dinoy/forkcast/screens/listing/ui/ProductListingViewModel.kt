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
import com.dinoy.forkcast.screens.listing.data.models.ListingQueryResult
import com.dinoy.forkcast.screens.listing.data.models.ListingRepository
import com.dinoy.forkcast.screens.listing.data.models.ListingState
import com.dinoy.forkcast.screens.listing.data.models.PredictRequest
import com.dinoy.forkcast.screens.listing.data.models.ProductCategory
import com.dinoy.forkcast.screens.listing.data.models.ProductData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class ProductListingViewModel @Inject constructor(private val listingRepository: ListingRepository) :
    ViewModel() {

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

        listingRepository.getProductListing(
            PredictRequest(
                date = state.selectedDate.toString(),
                latitude = 8.5686,
                longitude = 76.8731
            )
        ).collectLatest {
            when (it) {
                is ListingQueryResult.Success -> {
                    if (it.data == null) {
                        state = state.copy(queryState = ForkCastState.ServerError)
                        showSnackBar("Server Error")
                    } else {
                        productData.add(
                            ProductData(
                                category = ProductCategory.Soup,
                                quantity = it.data.Soup_Waste_kg
                            )
                        )

                        productData.add(
                            ProductData(
                                category = ProductCategory.Salad,
                                quantity = it.data.Salad_Waste_kg
                            )
                        )

                        productData.add(
                            ProductData(
                                category = ProductCategory.Dessert,
                                quantity = it.data.Dessert_Waste_kg
                            )
                        )

                        productData.add(
                            ProductData(
                                category = ProductCategory.Beverage,
                                quantity = it.data.Beverage_Waste_kg
                            )
                        )

                        productData.add(
                            ProductData(
                                category = ProductCategory.Appetizer,
                                quantity = it.data.Appetizer_Waste_kg
                            )
                        )

                        productData.add(
                            ProductData(
                                category = ProductCategory.MainCourse,
                                quantity = it.data.Main_Course_Waste_kg
                            )
                        )

                        state = state.copy(queryState = ForkCastState.Success)
                    }
                }
            }
        }
    }


}