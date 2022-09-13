package com.fyrl29074.cat_gram.presentation

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.fyrl29074.cat_gram.data.CatImageRepository
import com.fyrl29074.cat_gram.data.CatModel

class CatPagingSource : PagingSource<Int, CatModel>() {
    private val repository = CatImageRepository()
    override fun getRefreshKey(state: PagingState<Int, CatModel>): Int? = FIRST_PAGE

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CatModel> {
        val page = params.key ?: FIRST_PAGE
        return kotlin.runCatching {

            repository.getCatImageList(page)
        }.fold(
            onSuccess = {
                LoadResult.Page(
                    data = it,
                    prevKey = null,
                    nextKey = if (it.isEmpty()) null else page + 1
                )
            },
            onFailure = { LoadResult.Error(it) }
        )
    }

    private companion object {
        private const val FIRST_PAGE = 0
    }
}