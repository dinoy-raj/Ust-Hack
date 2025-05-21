package com.dinoy.forkcast.screens.listing.network

import com.dinoy.forkcast.screens.listing.data.models.ListingProductData
import com.dinoy.forkcast.screens.listing.data.models.PredictRequest
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("predict")
    suspend fun getProductData(@Body request: PredictRequest): ListingProductData
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