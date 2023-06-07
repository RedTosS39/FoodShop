package com.example.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class RepositoryImpl {
    private val apiService =  LocationApiService.create()
    private val liveData = MutableLiveData<Location>()

    private suspend fun getApiResult(lon: Double, lat: Double) {
        try {
            val result = apiService.getCityName(lon, lat)
            Log.d("AAAA", result[0].country)
            liveData.value = result
        } catch (_: Exception) {
        }
    }

     suspend fun getLocation(lon: Double, lat: Double): LiveData<Location> {
        getApiResult(lon, lat)
        return liveData
    }
}