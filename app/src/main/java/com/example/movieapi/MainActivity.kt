package com.example.movieapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movieapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var viewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareRecyclerView()
        viewModel=ViewModelProvider(this)[MovieViewModel::class.java]
        viewModel.getPopularMovies()

        viewModel.ObserveMoviLiveData().observe(this, Observer { movieList ->
            movieAdapter.setMovieList(movieList)
        })

    }

    private fun prepareRecyclerView() {
        movieAdapter= MovieAdapter()
        binding.rvMovies.apply {
            layoutManager=GridLayoutManager(applicationContext,2)
            adapter=movieAdapter
        }
    }
}