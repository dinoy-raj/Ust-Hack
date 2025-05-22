package com.dinoy.forkcast.di

import com.dinoy.forkcast.network.ApiService
import com.dinoy.forkcast.network.DinoRetroFit
import com.dinoy.forkcast.screens.details.data.model.DetailsRepository
import com.dinoy.forkcast.screens.listing.data.models.ListingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofitClient(): ApiService = DinoRetroFit.create()

    @Provides
    @Singleton
    fun provideDetailsRepository(apiService: ApiService): DetailsRepository =
        DetailsRepository(apiService)

    @Provides
    @Singleton
    fun provideListingRepository(apiService: ApiService): ListingRepository =
        ListingRepository(apiService)

}