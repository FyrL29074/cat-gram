package com.fyrl29074.cat_gram.presentation

import androidx.lifecycle.ViewModel
import com.fyrl29074.cat_gram.domain.GetCatImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCatImageUseCase: GetCatImageUseCase
) : ViewModel() {

    suspend fun reloadCatImage(): String {
        return getCatImageUseCase.execute().url
    }
}