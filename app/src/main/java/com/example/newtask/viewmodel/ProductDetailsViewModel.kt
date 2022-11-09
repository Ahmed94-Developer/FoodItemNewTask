package com.example.newtask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newtask.data.repository.FoodItemRepository
import com.example.newtask.data.repository.ProductDetailsRepository
import com.example.newtask.retrofit.data.Products
import com.example.newtask.retrofit.data.productdetails.ProductDetails
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductDetailsViewModel  @Inject constructor(val productDetailsRepository:ProductDetailsRepository) : ViewModel() {
    val productsDetailsliveData: LiveData<ProductDetails> get() = productDetailsRepository.productDetailsLiveData

   suspend fun getProductDetails(id : String){

            productDetailsRepository.getProductDetails(id)

    }
}