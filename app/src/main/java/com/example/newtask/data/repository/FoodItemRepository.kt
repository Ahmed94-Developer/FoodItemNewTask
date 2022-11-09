package com.example.newtask.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newtask.retrofit.DataApi
import com.example.newtask.retrofit.data.Products
import javax.inject.Inject

class FoodItemRepository @Inject constructor(val dataApi: DataApi) {
    val productsMutableLiveData : MutableLiveData<Products> = MutableLiveData()
    val productsLiveData : LiveData<Products> get() = productsMutableLiveData

    suspend fun getProducts(){
        val result = dataApi.getProducts()
        if (result.isSuccessful && result.body() != null){
            productsMutableLiveData.postValue(result.body())
        }
    }
}