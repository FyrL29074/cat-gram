package com.fyrl29074.cat_gram.data

class CatImageRepository {
    suspend fun getCatImageList(page: Int): List<CatModel> {
        return RetrofitService.searchImageApi.getCatImageList(page)
    }
}