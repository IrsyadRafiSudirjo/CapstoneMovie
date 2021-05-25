package com.example.core.utils

import com.example.core.data.source.remote.response.MovieResponse
import com.example.core.domain.model.Movie

object DataMapper {
    fun mapResponsesToEntities(input: List<MovieResponse>): List<com.example.core.data.source.local.entity.MovieEntity> {
        val movielist = ArrayList<com.example.core.data.source.local.entity.MovieEntity>()
        input.map {
            val movie = com.example.core.data.source.local.entity.MovieEntity(
                movieId = it.id,
                overview = it.overview,
                title = it.title,
                image = it.image,
                favorite = false
            )
            movielist.add(movie)
        }
        return movielist
    }

    fun mapEntitiesToDomain(input: List<com.example.core.data.source.local.entity.MovieEntity>): List<Movie> =
        input.map {
            Movie(
                movieId = it.movieId,
                overview = it.overview,
                title = it.title,
                image = "https://image.tmdb.org/t/p/w500/${it.image}",
                favorite = it.favorite
            )
        }

    val image = "https://image.tmdb.org/t/p/w500/"
    fun mapDomainToEntity(input: Movie) = com.example.core.data.source.local.entity.MovieEntity(
        movieId = input.movieId,
        overview = input.overview,
        title = input.title,
        image = image + input.image,
        favorite = input.favorite
    )
}