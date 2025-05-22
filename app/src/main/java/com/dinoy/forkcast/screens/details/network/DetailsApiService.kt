package com.dinoy.forkcast.screens.details.network

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


interface DetailsApiService {
    @POST("predict-week")
    suspend fun getProductData(@Body request: PredictDetailsRequest): List<ProductDetailsData>
}


object DinoRetroFit {

    const val BASE_URL = "https://o207ltrv.leopard-boa.ts.net/"

    fun create(): DetailsApiService {
        val client = OkHttpClient.Builder().build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DetailsApiService::class.java)
    }
}