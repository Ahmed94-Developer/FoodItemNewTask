package com.example.newtask.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newtask.data.repository.FoodItemRepository
import com.example.newtask.data.repository.ProductDetailsRepository
import javax.inject.Inject

class ProductDetailsViewModelFactory @Inject constructor(val  ProductDetailsRepository: ProductDetailsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProductDetailsViewModel(ProductDetailsRepository) as T
    }
}