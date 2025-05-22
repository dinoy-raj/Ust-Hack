package com.dinoy.forkcast.screens.details.data.model

data class ProductDetailsData(
    val date: String,
    val holiday_name: String,
    val humidity: Int,
    val is_holiday: Int,
    val is_raining: Int,
    val is_sunny: Int,
    val is_weekend: Int,
    val model_insights: ModelInsights,
    val predictions: Double,
    val temperature: Double
)