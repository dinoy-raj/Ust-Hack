package com.dinoy.forkcast.network

import com.google.gson.annotations.SerializedName

data class WeeklyPredictionResponse(
    @SerializedName("weekly_predictions")
    val weeklyPredictions: List<DailyPrediction>
)

data class DailyPrediction(
    val date: String,
    val temperature: Double,
    val humidity: Int,
    @SerializedName("is_weekend")
    val isWeekend: Int,
    @SerializedName("is_holiday")
    val isHoliday: Int,
    @SerializedName("is_raining")
    val isRaining: Int,
    @SerializedName("is_sunny")
    val isSunny: Int,
    @SerializedName("holiday_name")
    val holidayName: String,
    val predictions: Double,
    @SerializedName("model_insights")
    val modelInsights: ModelInsights
)

data class ModelInsights(
    val accuracy: Double,
    @SerializedName("feature_contributions_percent")
    val featureContributionsPercent: Map<String, Double>
)