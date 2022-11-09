package com.example.newtask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newtask.data.repository.FoodItemRepository
import com.example.newtask.retrofit.data.Products
import kotlinx.coroutines.launch
import javax.inject.Inject

class FoodItemsViewModel @Inject constructor(val foodItemRepository: FoodItemRepository) : ViewModel(){
    val foodItemsLiveData : LiveData<Products> get() = foodItemRepository.productsLiveData

    init {
        viewModelScope.launch {
            foodItemRepository.getProducts()
        }
    }
}