package com.example.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class RepositoryImpl() {
    private val apiService =  LocationApiService.create()
    private val liveData = MutableLiveData<Location>()

    private suspend fun getApiResult() {
        try {
            val result = apiService.getCityName()
            Log.d("AAAA", result[0].country)
            liveData.value = result
        } catch (_: Exception) {
        }
    }

     suspend fun getLocation(): LiveData<Location> {
        getApiResult()

        return liveData
    }
}