package com.dinoy.forkcast.screens.details.data.model

import android.util.Log
import com.dinoy.forkcast.network.ApiService
import com.dinoy.forkcast.network.PredictDetailsRequest
import com.dinoy.forkcast.network.WeeklyPredictionResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


sealed class DetailsQueryResult {
    data class Success(val data: WeeklyPredictionResponse?) : DetailsQueryResult()
}


class DetailsRepository @Inject constructor(val apiService: ApiService) {

    fun getProductDetails(request: PredictDetailsRequest): Flow<DetailsQueryResult> = flow {
        val response = apiService.getProductDetails(request)
        emit(DetailsQueryResult.Success(response))
    }.catch { e ->
        // handle error
        Log.d("TAG", e.message.toString())
        emit(DetailsQueryResult.Success(null)) // or throw if needed
    }
}