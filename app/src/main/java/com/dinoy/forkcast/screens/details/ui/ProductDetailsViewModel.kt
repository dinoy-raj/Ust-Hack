package com.dinoy.forkcast.screens.details.ui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dinoy.forkcast.models.ForkCastState
import com.dinoy.forkcast.network.DinoRetroFit
import com.dinoy.forkcast.network.PredictDetailsRequest
import com.dinoy.forkcast.screens.details.data.model.DayWiseQuantity
import com.dinoy.forkcast.screens.details.data.model.DetailsQueryResult
import com.dinoy.forkcast.screens.details.data.model.DetailsRepository
import com.dinoy.forkcast.screens.details.data.model.DetailsState
import com.dinoy.forkcast.screens.details.data.model.Features
import com.dinoy.forkcast.screens.details.data.model.FeaturesId
import com.dinoy.forkcast.screens.details.data.model.ProductDetails
import com.dinoy.forkcast.screens.listing.data.models.ProductCategory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(private val detailsRepository: DetailsRepository) :
    ViewModel() {

    var state by mutableStateOf(DetailsState())
    var features = mutableStateListOf<Features>()

    fun setInitialArguments(date: String, category: ProductCategory) = viewModelScope.launch {
        state = state.copy(
            isQueryLoading = true,
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

    fun setSelectedIndex(index: Int) {
        features.clear()
        state.productDetails?.weeklyData?.get(index)?.features?.let {
            features.addAll(it)

        }
        state = state.copy(selectedIndex = index)
    }

    fun fetchDetailsQuery() = viewModelScope.launch {
        state = state.copy(
            queryState = ForkCastState.Loading,
            productDetails = null,
            selectedIndex = 0,
            isQueryLoading = true,
        )
        features.clear()
        detailsRepository.getProductDetails(
            PredictDetailsRequest(
                date = state.selectedDate.toString(),
                latitude = 8.5686,
                longitude = 76.8731,
                filter = state.selectedCategory.getSoorajId()
            )
        ).collectLatest { response ->
            when (response) {
                is DetailsQueryResult.Success -> {
                    if (response.data == null) {
                        state = state.copy(
                            queryState = ForkCastState.ServerError,
                            isQueryLoading = false
                        )
                    } else {

                        val productDetails = ProductDetails(
                            category = state.selectedCategory,
                            weeklyData = response.data.weeklyPredictions.map {
                                val date = LocalDate.parse(it.date)
                                DayWiseQuantity(
                                    date = date,
                                    quantity = it.predictions,
                                    accuracy = it.modelInsights.accuracy,
                                    features = it.modelInsights.featureContributionsPercent.map { data ->
                                        when (data.key) {
                                            FeaturesId.Is_Holiday.name -> Features.Holiday(
                                                percentage = data.value
                                            )

                                            FeaturesId.Is_Raining.name -> Features.Rainy(
                                                percentage = data.value
                                            )

                                            FeaturesId.Is_Sunny.name -> Features.Sunny(
                                                percentage = data.value
                                            )

                                            FeaturesId.Is_Weekend.name -> Features.Weekend(
                                                percentage = data.value
                                            )

                                            FeaturesId.Temperature.name -> Features.Temperature(
                                                percentage = data.value,
                                                currentValue = it.temperature
                                            )

                                            FeaturesId.Humidity.name -> Features.Humidity(
                                                percentage = data.value,
                                                currentValue = it.humidity.toDouble()
                                            )

                                            else -> Features.None
                                        }
                                    }
                                )
                            }
                        )

                        features.clear()
                        productDetails.weeklyData[state.selectedIndex].features.let {
                            features.addAll(
                                it
                            )
                        }

                        state = state.copy(
                            productDetails = productDetails,
                            average = response.data.weeklyPredictions.sumOf { it.predictions } / 7,
                            queryState = ForkCastState.Success,
                            isQueryLoading = false
                        )
                    }
                }
            }
        }
    }

    fun setSelectedDate(toLocalDate: LocalDate) = viewModelScope.launch {
        state = state.copy(
            selectedDate = toLocalDate
        )
        features.clear()
        fetchDetailsQuery()
    }

}