package com.example.foodshop.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.data.Location
import com.example.data.RepositoryImpl
import com.example.data.category.model.Category
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repositoryImpl = RepositoryImpl()

    private var _cityLabel = MutableLiveData<Location>()
    val cityLabel: LiveData<Location> get() = _cityLabel

    private var _category = MutableLiveData<List<Category>>()
    val category: LiveData<List<Category>> get() = _category


    init {
        getCategoryList()
    }

    fun getParams(lon: Double, lat: Double) {
        viewModelScope.launch {
            val location = repositoryImpl.getApiResult(lon, lat)
            _cityLabel.postValue(location.value)
        }
    }

    private fun getCategoryList() {

        viewModelScope.launch {
            val categoryList = repositoryImpl.getCategory()
            _category.value = categoryList.value
        }
    }
}