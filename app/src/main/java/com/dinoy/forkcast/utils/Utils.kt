package com.dinoy.forkcast.utils

import com.dinoy.forkcast.screens.listing.data.models.ProductCategory
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale


fun getDayInitial(date: LocalDate): String {
    val dayOfWeek = date.dayOfWeek
    // Get the first letter of the short name (e.g. "Mon" -> "M")
    return dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.ENGLISH).first().toString()
}

fun getComparisonValue(productCategory: ProductCategory): Double = when(productCategory)
{
    ProductCategory.MainCourse -> 80.0
    else -> 40.0
}

fun Double.toPercentageStringFormatted(decimalPlaces: Int = 0, includeSymbol: Boolean = true): String {
    val percentageValue = this * 100
    val formatString = "%.${decimalPlaces}f" // Creates format like "%.0f", "%.2f"
    val formattedValue = String.format(formatString, percentageValue)
    return if (includeSymbol) {
        "$formattedValue%"
    } else {
        formattedValue
    }
}