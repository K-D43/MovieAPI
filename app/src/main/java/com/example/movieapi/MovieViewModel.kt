package com.example.movieapi

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapi.data.Movies
import com.example.movieapi.data.result
import com.example.movieapi.retrofit.retrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MovieViewModel : ViewModel() {

    private val movieLiveData = MutableLiveData<List<result>>()

    fun getPopularMovies(){
        retrofitInstance.api.getPopularMovies("1677de26842dffcf3d92c282a2880e9b").enqueue(object : Callback<Movies>{
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                if (response.body()!=null){
                    movieLiveData.value=response.body()!!.results
                }
                else{
                    return
                }
            }

            override fun onFailure(call: Call<Movies>, t: Throwable) {
                Log.d("TAG",t.message.toString())
            }

        })
    }


    fun ObserveMoviLiveData() : LiveData<List<result>>{
        return movieLiveData
    }



}
