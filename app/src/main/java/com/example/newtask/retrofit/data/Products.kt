package com.example.newtask.retrofit.data

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import com.example.newtask.retrofit.data.Product

@Generated("jsonschema2pojo")
class Products {
    @SerializedName("products")
    @Expose
    var products: List<Product>? = null

    @SerializedName("total")
    @Expose
    var total: Int? = null

    @SerializedName("skip")
    @Expose
    var skip: Int? = null

    @SerializedName("limit")
    @Expose
    var limit: Int? = null
}