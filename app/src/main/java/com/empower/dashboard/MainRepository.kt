package com.empower.dashboard

import com.empower.network.RetrofitInstance

class MainRepository {
    suspend fun pickupRequest(body:Map<String,String>): TripSheetResponse? = RetrofitInstance.apiService?.pickupRequest(body)
}