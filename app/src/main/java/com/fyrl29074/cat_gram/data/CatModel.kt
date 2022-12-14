package com.fyrl29074.cat_gram.data

import com.google.gson.annotations.SerializedName

data class CatModel(
    @SerializedName("url") val url: String,
    @SerializedName("width") val width: Int,
    @SerializedName("height") val height: Int,
)