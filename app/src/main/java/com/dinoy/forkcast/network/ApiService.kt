package com.dinoy.forkcast.network

import com.dinoy.forkcast.screens.details.data.model.ProductDetailsData
import com.dinoy.forkcast.screens.listing.data.models.ListingProductData
import com.dinoy.forkcast.screens.listing.data.models.PredictRequest
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

data class PredictDetailsRequest(
    val date: String,
    val latitude: Double,
    val longitude: Double,
    val filter: String
)


interface ApiService {

    @POST("predict-week")
    suspend fun getProductDetails(@Body request: PredictDetailsRequest): List<ProductDetailsData>

    @POST("predict")
    suspend fun getProductListingDetails(@Body request: PredictRequest): ListingProductData
}


object DinoRetroFit {

    const val BASE_URL = "https://o207ltrv.leopard-boa.ts.net/"

    fun create(): ApiService {
        val client = OkHttpClient.Builder().build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}