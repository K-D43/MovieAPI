package com.example.movieapi.retrofit

import com.example.movieapi.data.Movies
import com.example.movieapi.data.result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface retrofitService {

    @GET("popular?")
    fun getPopularMovies(@Query("api_key") api_key:String): Call<Movies>

}