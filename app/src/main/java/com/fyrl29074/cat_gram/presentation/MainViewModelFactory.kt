package com.fyrl29074.cat_gram.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fyrl29074.cat_gram.domain.GetCatImageUseCase
import java.lang.IllegalArgumentException
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(
    private val getCatImageUseCase: GetCatImageUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(getCatImageUseCase) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}