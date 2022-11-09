package com.example.newtask.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newtask.data.repository.FoodItemRepository
import javax.inject.Inject

class FoodItemViewModelFactory @Inject constructor(val foodItemRepository: FoodItemRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FoodItemsViewModel(foodItemRepository) as T
    }

}