package com.dinoy.forkcast.screens.details.data.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AcUnit
import androidx.compose.material.icons.outlined.AutoGraph
import androidx.compose.material.icons.outlined.BusinessCenter
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Grain
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.WbSunny
import androidx.compose.ui.graphics.vector.ImageVector
import com.dinoy.forkcast.R
import com.dinoy.forkcast.screens.listing.data.models.ProductCategory
import java.time.LocalDate


data class ProductDetails(
    val category: ProductCategory = ProductCategory.Beverage,
    val weeklyData: List<DayWiseQuantity> = listOf()
)

data class DayWiseQuantity(
    val date: LocalDate = LocalDate.now(),
    val quantity: Double = 0.0,
    val accuracy: Double = 0.0,
    val features: List<Features> = listOf()
)

interface FeatureMetaData {
    fun getNameResourceId(): Int
    fun getIcon(): ImageVector
}


sealed class Features : FeatureMetaData {
    data class Sunny(val percentage: Double) : Features() {
        override fun getNameResourceId(): Int {
            return R.string.sunny_day
        }

        override fun getIcon(): ImageVector {
            return Icons.Outlined.WbSunny
        }
    }

    data class Rainy(val percentage: Double) : Features() {
        override fun getNameResourceId(): Int {
            return R.string.rainy_day
        }

        override fun getIcon(): ImageVector {
            return Icons.Outlined.Grain
        }
    }


    data class Humidity(val percentage: Double, val currentValue: Double) : Features() {
        override fun getNameResourceId(): Int {
            return R.string.humidity
        }

        override fun getIcon(): ImageVector {
            return Icons.Outlined.AcUnit
        }
    }

    data class Temperature(val percentage: Double, val currentValue: Double) : Features() {
        override fun getNameResourceId(): Int {
            return R.string.temperature
        }

        override fun getIcon(): ImageVector {
            return Icons.Outlined.AutoGraph
        }
    }

    data class Weekend(val percentage: Double) : Features() {
        override fun getNameResourceId(): Int {
            return R.string.weekend
        }

        override fun getIcon(): ImageVector {
            return Icons.Outlined.Home
        }
    }

    data class Holiday(val percentage: Double) : Features() {
        override fun getNameResourceId(): Int {
            return R.string.holiday
        }

        override fun getIcon(): ImageVector {
            return Icons.Outlined.Favorite
        }
    }

    data class WeekDay(val percentage: Double) : Features() {
        override fun getNameResourceId(): Int {
            return R.string.weekday
        }

        override fun getIcon(): ImageVector {
            return Icons.Outlined.BusinessCenter
        }
    }
}
