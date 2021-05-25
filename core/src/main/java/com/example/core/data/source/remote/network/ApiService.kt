package com.example.core.data.source.remote.network

import com.example.core.data.source.remote.response.ListMovieResponse
import retrofit2.http.GET

interface ApiService {
    @GET("now_playing?api_key=45e2639a332e12952d7137e21bb97cf3&language=en-US&page=1")
    suspend fun getList(): ListMovieResponse //hapus Call, tambahkan suspend
}