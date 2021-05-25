package com.example.core.domain.usecase

import com.example.core.domain.model.Movie
import com.example.core.domain.repository.InterfaceMovieRepository
import javax.inject.Inject

class MovieInteractor @Inject constructor(private val interfaceMovieRepository: InterfaceMovieRepository) :
    MovieUseCase {

    override fun getAllMovie() = interfaceMovieRepository.getAllMovie()

    override fun getFavoriteMovie() = interfaceMovieRepository.getFavoriteMovie()

    override fun setFavoriteMovie(movie: Movie, state: Boolean) =
        interfaceMovieRepository.setFavoriteMovie(movie, state)
}