package com.dinoy.forkcast.screens.listing.data.models

data class ListingProductData(
    val date: String,
    val holiday_name: String,
    val is_holiday: Int,
    val is_weekend: Int,
    val predictions: Predictions
)