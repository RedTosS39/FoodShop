package com.example.foodshop.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.RepositoryImpl
import com.example.data.category.model.dishes.Dishe
import com.example.data.category.model.dishes.Dishes
import kotlinx.coroutines.launch

class DishesViewModel : ViewModel() {
    private val repositoryImpl = RepositoryImpl()

    private val _dishesLiveData = MutableLiveData<List<Dishe>>()
     val dishesLiveData: LiveData<List<Dishe>> get() = _dishesLiveData

    init {
        getDishes()
    }
    private fun getDishes() {
        viewModelScope.launch {
            _dishesLiveData.value = repositoryImpl.getDishes().value
        }
    }
}