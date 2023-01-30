package com.example.movieapi.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class retrofitInstance {

    companion object{

        private val baseUrl="https://api.themoviedb.org/3/movie/"

        val api:retrofitService by lazy {
            Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(retrofitService::class.java)
        }

    }

}