package com.dinoy.forkcast.screens.listing.data.models

interface MetaData {
    fun getImageResourceId(): Int
    fun getNameResourceId(): Int
}


//enum class ProductCategory: MetaData {
//    Dessert {
//        override fun getImageResourceId(): Int {
//            TODO("Not yet implemented")
//        }
//
//        override fun getNameResourceId(): Int {
//            TODO("Not yet implemented")
//        }
//    },
//    Soup {
//        override fun getImageResourceId(): Int {
//            TODO("Not yet implemented")
//        }
//
//        override fun getNameResourceId(): Int {
//            TODO("Not yet implemented")
//        }
//    },
//    MainCourse {
//        override fun getImageResourceId(): Int {
//            TODO("Not yet implemented")
//        }
//
//        override fun getNameResourceId(): Int {
//            TODO("Not yet implemented")
//        }
//    },
//    Appetizer,
//    Salad,
//    Beverage
//}