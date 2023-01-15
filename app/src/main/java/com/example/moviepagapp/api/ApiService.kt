package com.example.moviepagapp.api

import com.example.moviepagapp.Utils.Constans
import com.example.moviepagapp.models.ApiResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(Constans.End_Point + Constans.Api_Key)
    suspend fun getAllMovies(
        @Query("page") page: Int
    ) : Response<ApiResponse>

    @GET(Constans.End_Point + Constans.Api_Key)
    fun getAllMovie():Call<ApiResponse>
}