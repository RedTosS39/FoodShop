package com.example.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.data.category.model.Category
import com.example.data.category.model.CategoryList
import com.example.data.category.response.CategoryApiService
import kotlinx.coroutines.coroutineScope

class RepositoryImpl {
    private val apiService =  LocationApiService.create()
    private val categoryApiService =  CategoryApiService.create()

    private val locationLiveData = MutableLiveData<Location>()
    private val categoryLiveData = MutableLiveData<List<Category>>()

    suspend fun getApiResult(lon: Double, lat: Double) : LiveData<Location>  {
        try {
            val result = apiService.getCityName(lon, lat)
            locationLiveData.value = result
        } catch (_: Exception) {
        }

        return locationLiveData
    }

    suspend fun getCategory() : LiveData<List<Category>> {
        val result = categoryApiService.getCategoryApi()
        categoryLiveData.value = result.сategories
        return categoryLiveData
    }
}