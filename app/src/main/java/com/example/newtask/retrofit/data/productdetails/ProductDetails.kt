package com.example.newtask.retrofit.data.productdetails

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

@Generated("jsonschema2pojo")
class ProductDetails {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("price")
    @Expose
    var price: Int? = null

    @SerializedName("discountPercentage")
    @Expose
    var discountPercentage: Double? = null

    @SerializedName("rating")
    @Expose
    var rating: Double? = null

    @SerializedName("stock")
    @Expose
    var stock: Int? = null

    @SerializedName("brand")
    @Expose
    var brand: String? = null

    @SerializedName("category")
    @Expose
    var category: String? = null

    @SerializedName("thumbnail")
    @Expose
    var thumbnail: String? = null

    @SerializedName("images")
    @Expose
    var images: List<String>? = null
}