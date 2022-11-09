package com.example.newtask.retrofit

import com.example.newtask.retrofit.data.Products
import com.example.newtask.retrofit.data.productdetails.ProductDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DataApi {
    @GET("products")
    suspend fun getProducts() : Response<Products>

    @GET("products/{id}")
   suspend fun getproductDetails(@Path("id")id : String) : Response<ProductDetails>
}