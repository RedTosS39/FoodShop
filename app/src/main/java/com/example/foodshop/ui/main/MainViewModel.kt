package com.example.foodshop.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.data.Location
import com.example.data.RepositoryImpl
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val repositoryImpl = RepositoryImpl()

    private var _cityLabel = MutableLiveData<Location>()
    val cityLabel: LiveData<Location> get() = _cityLabel

    init {
        setupLiveData()
    }
     private fun setupLiveData() {
         viewModelScope.launch {
             val location = repositoryImpl.getLocation()
             _cityLabel.postValue(location.value)
         }
    }
}