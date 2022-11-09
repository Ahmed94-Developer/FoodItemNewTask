package com.example.newtask.retrofit.data

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

@Generated("jsonschema2pojo")
class Posts {
    @SerializedName("userId")
    @Expose
    var userId: Int? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("body")
    @Expose
    var body: String? = null
}