package com.example.core.data.source.local

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val movieDao: com.example.core.data.source.local.room.MovieDao) {


    fun getAllMovie(): Flow<List<com.example.core.data.source.local.entity.MovieEntity>> =
        movieDao.getAllMovie()

    fun getFavoriteMovie(): Flow<List<com.example.core.data.source.local.entity.MovieEntity>> =
        movieDao.getFavoriteMovie()

    suspend fun insertMovie(movieList: List<com.example.core.data.source.local.entity.MovieEntity>) =
        movieDao.insertMovie(movieList)

    fun setFavoriteMovie(
        movie: com.example.core.data.source.local.entity.MovieEntity,
        newState: Boolean
    ) {
        movie.favorite = newState
        movieDao.updateFavoriteMovie(movie)
    }
}