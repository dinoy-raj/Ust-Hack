package com.dinoy.forkcast.screens.listing.data.models

data class ListingProductData(
    val Appetizer_Waste_kg: Double,
    val Beverage_Waste_kg: Double,
    val Date: String,
    val Dessert_Waste_kg: Double,
    val Holiday_Name: Any,
    val Humidity: Int,
    val Is_Holiday: Int,
    val Is_Raining: Int,
    val Is_Sunny: Int,
    val Main_Course_Waste_kg: Double,
    val Salad_Waste_kg: Double,
    val Soup_Waste_kg: Double,
    val Temperature: Double,
    val is_weekend: Int
)