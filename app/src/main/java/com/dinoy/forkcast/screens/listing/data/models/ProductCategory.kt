package com.dinoy.forkcast.screens.listing.data.models

import com.dinoy.forkcast.R

interface MetaData {
    fun getImageResourceId(): Int
    fun getNameResourceId(): Int
}


enum class ProductCategory : MetaData {
    Dessert {
        override fun getImageResourceId(): Int {
            return R.drawable.dessert
        }

        override fun getNameResourceId(): Int {
            return R.string.dessert
        }
    },
    Soup {
        override fun getImageResourceId(): Int {
            return R.drawable.soup
        }

        override fun getNameResourceId(): Int {
            return R.string.soup
        }
    },
    MainCourse {
        override fun getImageResourceId(): Int {
            return R.drawable.main
        }

        override fun getNameResourceId(): Int {
            return R.string.main_course
        }
    },
    Appetizer {
        override fun getImageResourceId(): Int {
            return R.drawable.appe
        }

        override fun getNameResourceId(): Int {
            return R.string.appetizer
        }
    },
    Salad {
        override fun getImageResourceId(): Int {
            return R.drawable.salad
        }

        override fun getNameResourceId(): Int {
            return R.string.salad
        }
    },
    Beverage {
        override fun getImageResourceId(): Int {
            return R.drawable.bev
        }

        override fun getNameResourceId(): Int {
            return R.string.beverage
        }
    }
}