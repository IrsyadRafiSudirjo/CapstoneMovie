package com.example.core.data.source.local.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie")
    fun getAllMovie(): Flow<List<com.example.core.data.source.local.entity.MovieEntity>>

    @Query("SELECT * FROM movie where favorite = 1")
    fun getFavoriteMovie(): Flow<List<com.example.core.data.source.local.entity.MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: List<com.example.core.data.source.local.entity.MovieEntity>)

    @Update
    fun updateFavoriteMovie(movie: com.example.core.data.source.local.entity.MovieEntity)
}