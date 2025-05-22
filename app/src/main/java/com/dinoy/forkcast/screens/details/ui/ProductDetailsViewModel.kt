package com.dinoy.forkcast.screens.details.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.util.fastForEach
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dinoy.forkcast.models.ForkCastState
import com.dinoy.forkcast.network.DinoRetroFit
import com.dinoy.forkcast.network.PredictDetailsRequest
import com.dinoy.forkcast.screens.details.data.model.DayWiseQuantity
import com.dinoy.forkcast.screens.details.data.model.DetailsState
import com.dinoy.forkcast.screens.details.data.model.Features
import com.dinoy.forkcast.screens.details.data.model.ProductDetails
import com.dinoy.forkcast.screens.listing.data.models.ProductCategory
import com.dinoy.forkcast.screens.listing.data.models.ProductData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor() : ViewModel() {

    var state by mutableStateOf(DetailsState())
    val productData = mutableStateListOf<ProductDetails>()

    fun setInitialArguments(date: String, category: ProductCategory) = viewModelScope.launch {
        state = state.copy(
            notFetched = false
        )
        try {
            state = state.copy(
                selectedDate = LocalDate.parse(date),
            )
        } catch (e: Exception) {

        }
        state = state.copy(
            selectedCategory = category
        )
        fetchDetailsQuery()
    }

    fun fetchDetailsQuery() = viewModelScope.launch {
        state = state.copy(queryState = ForkCastState.Loading)
        productData.clear()
        try {
            val response = DinoRetroFit.create().getProductDetails(
                PredictDetailsRequest(
                    date = state.selectedDate.toString(),
                    latitude = 8.5686,
                    longitude = 76.8731,
                    filter = state.selectedCategory.getSoorajId()
                )
            )

            ProductDetails(
                category = state.selectedCategory,
                weeklyData = response.map {
                    val date = LocalDate.parse(it.date)
                    DayWiseQuantity(
                        date = date,
                        quantity = it.predictions,
                        accuracy = it.model_insights.accuracy,
                        features = listOf(
                            Features.Humidity(
                                percentage = it.model_insights.feature_contributions_percent.Humidity,
                                currentValue = it.humidity.toDouble()
                            ),
                            Features.Temperature(
                                percentage = it.model_insights.feature_contributions_percent.Temperature,
                                currentValue = it.temperature
                            ),
                            Features.Sunny(
                                percentage = it.model_insights.feature_contributions_percent.Is_Sunny
                            ),
                            Features.Rainy(
                                percentage = it.model_insights.feature_contributions_percent.Is_Raining
                            ),
                            Features.Weekend(
                                percentage = it.model_insights.feature_contributions_percent.Is_Weekend
                            ),
                            Features.WeekDay(
                                percentage = it.model_insights.feature_contributions_percent.DayOfWeek
                            ),
                            Features.Holiday(
                                percentage = it.model_insights.feature_contributions_percent.Is_Holiday
                            )
                        )
                    )
                }
            )

            state = state.copy(
                queryState = ForkCastState.Success
            )

        } catch (e: Exception) {
            state = state.copy(
                queryState = ForkCastState.ServerError
            )
        }
    }

}