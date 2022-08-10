package com.fyrl29074.cat_gram.domain

import com.fyrl29074.cat_gram.data.CatImageRepository
import com.fyrl29074.cat_gram.entity.CatImage
import javax.inject.Inject

class GetCatImageUseCase @Inject constructor(
    private val catImageRepository: CatImageRepository
) {

    suspend fun execute(): CatImage {
        return catImageRepository.getCatImage()
    }
}