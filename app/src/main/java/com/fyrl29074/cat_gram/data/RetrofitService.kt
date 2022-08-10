package com.fyrl29074.cat_gram.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


const val BASE_URL = "https://api.thecatapi.com/"
object RetrofitService {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val searchImageApi: SearchImageApi = retrofit.create(SearchImageApi::class.java)
}

interface SearchImageApi {
    @GET("v1/images/search?limit=1")
    suspend fun getCatImage(): List<CatImageDto>
}