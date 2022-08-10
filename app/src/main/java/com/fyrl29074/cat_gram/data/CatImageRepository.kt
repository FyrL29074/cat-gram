package com.fyrl29074.cat_gram.data

import com.fyrl29074.cat_gram.entity.CatImage
import javax.inject.Inject

class CatImageRepository @Inject constructor(){

    suspend fun getCatImage(): CatImage {
        return downloadCatImage()
    }

    private suspend fun downloadCatImage(): CatImageDto {
        return CatImageDto(RetrofitService.searchImageApi.getCatImage().first().url)
    }
}