package com.example.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.data.category.model.categories.Category
import com.example.data.category.model.dishes.Dishe
import com.example.data.category.model.location.Location
import com.example.data.category.response.CategoryApiService
import com.example.data.category.response.DishesApiService

class RepositoryImpl {
    private val apiService = LocationApiService.create()
    private val categoryApiService = CategoryApiService.create()
    private val dishesApiService = DishesApiService.create()

    private val locationLiveData = MutableLiveData<Location>()
    private val categoryLiveData = MutableLiveData<List<Category>>()
    private val dishesLiveData = MutableLiveData<List<Dishe>>()

    suspend fun getApiResult(lon: Double, lat: Double): LiveData<Location> {
        try {
            val result = apiService.getCityName(lon, lat)
            locationLiveData.value = result
        } catch (_: Exception) {
        }

        return locationLiveData
    }

    suspend fun getCategory(): LiveData<List<Category>> {
        try {
            val result = categoryApiService.getCategoryApi()
            categoryLiveData.value = result.сategories
        } catch (_: Exception) {
        }
        return categoryLiveData
    }

    suspend fun getDishes(): LiveData<List<Dishe>> {
        try {
            val result = dishesApiService.getDishes()
            dishesLiveData.value = result.dishes
            Log.d("AAAA", "getDishes: ${result.dishes}")
        } catch (_: Exception) {
        }
        return dishesLiveData
    }
}