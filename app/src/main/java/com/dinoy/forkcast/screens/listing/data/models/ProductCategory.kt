package com.dinoy.forkcast.screens.listing.data.models

import com.dinoy.forkcast.R

interface MetaData {
    fun getImageResourceId(): Int
    fun getNameResourceId(): Int
    fun getSoorajId(): String
}

enum class ProductCategory : MetaData {
    Dessert {
        override fun getImageResourceId(): Int {
            return R.drawable.dessert
        }

        override fun getNameResourceId(): Int {
            return R.string.dessert
        }

        override fun getSoorajId(): String {
            return "Dessert_Waste_kg"
        }
    },
    Soup {
        override fun getImageResourceId(): Int {
            return R.drawable.soup
        }

        override fun getNameResourceId(): Int {
            return R.string.soup
        }

        override fun getSoorajId(): String {
            return "Soup_Waste_kg"
        }
    },
    MainCourse {
        override fun getImageResourceId(): Int {
            return R.drawable.main
        }

        override fun getNameResourceId(): Int {
            return R.string.main_course
        }

        override fun getSoorajId(): String {
            return "Main_Course_Waste_kg"
        }
    },
    Appetizer {
        override fun getImageResourceId(): Int {
            return R.drawable.appe
        }

        override fun getNameResourceId(): Int {
            return R.string.appetizer
        }

        override fun getSoorajId(): String {
            return "Appetizer_Waste_kg"
        }
    },
    Salad {
        override fun getImageResourceId(): Int {
            return R.drawable.salad
        }

        override fun getNameResourceId(): Int {
            return R.string.salad
        }

        override fun getSoorajId(): String {
            return "Salad_Waste_kg"
        }
    },
    Beverage {
        override fun getImageResourceId(): Int {
            return R.drawable.bev
        }

        override fun getNameResourceId(): Int {
            return R.string.beverage
        }

        override fun getSoorajId(): String {
            return "Beverage_Waste_kg"
        }
    }
}