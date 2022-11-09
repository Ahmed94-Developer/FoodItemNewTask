package com.example.newtask.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newtask.retrofit.DataApi
import com.example.newtask.retrofit.data.productdetails.ProductDetails
import javax.inject.Inject

class ProductDetailsRepository @Inject constructor(val dataApi: DataApi) {
    val mutablePproductDetails : MutableLiveData<ProductDetails> = MutableLiveData()
    val productDetailsLiveData : LiveData<ProductDetails> get() = mutablePproductDetails

    suspend fun getProductDetails(id : String){
        val result = dataApi.getproductDetails(id)
        if (result.isSuccessful && result.body() != null){
            mutablePproductDetails.postValue(result.body())
        }
    }
}