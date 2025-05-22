package com.dinoy.forkcast.screens.listing.data.models

import com.dinoy.forkcast.network.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


sealed class ListingQueryResult {
    data class Success(val data: ListingProductData?) : ListingQueryResult()
}


class ListingRepository @Inject constructor(val apiService: ApiService) {

    fun getProductListing(request: PredictRequest): Flow<ListingQueryResult> = flow {
        val response = apiService.getProductListingDetails(request)
        emit(ListingQueryResult.Success(response))
    }.catch { e ->
        emit(ListingQueryResult.Success(null))
    }
}