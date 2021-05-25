package com.example.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.core.domain.usecase.MovieUseCase

class FViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val movie = movieUseCase.getFavoriteMovie().asLiveData()
}