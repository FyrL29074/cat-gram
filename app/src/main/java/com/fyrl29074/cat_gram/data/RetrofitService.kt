package com.fyrl29074.cat_gram.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


const val BASE_URL = "https://api.thecatapi.com/"

object RetrofitService {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val searchImageApi: SearchImageApi = retrofit.create(SearchImageApi::class.java)
}

interface SearchImageApi {
    @GET("v1/images/search?limit=10&api_key=$api_key")
    suspend fun getCatImageList(@Query("page") page : Int): List<CatModel>

    private companion object {
        private const val api_key =
            "live_DWQJ7jy5SHhn4wjJXK0ClZFGgJjMfdmxfu7aOwDbQ5NSXWR3uLu6RevkUdqtyhPW"
    }
}