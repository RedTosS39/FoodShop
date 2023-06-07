package com.example.foodshop.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _cityLabel = MutableLiveData<String>()
    val cityLabel: LiveData<String> get() = _cityLabel

    init {
        setupLiveData()
    }
    private fun setupLiveData() {
        _cityLabel.value = "Saint Petersburg"
    }
}