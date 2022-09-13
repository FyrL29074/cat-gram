package com.fyrl29074.cat_gram.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.fyrl29074.cat_gram.data.CatImageRepository
import com.fyrl29074.cat_gram.data.CatModel
import kotlinx.coroutines.flow.Flow

class CatsViewModel : ViewModel() {

    val cats: Flow<PagingData<CatModel>> = Pager(
        config = PagingConfig(pageSize = 10),
        pagingSourceFactory = { CatPagingSource() }
    ).flow.cachedIn(viewModelScope)
}