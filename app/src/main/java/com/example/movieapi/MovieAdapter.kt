package com.example.movieapi

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapi.data.result
import com.example.movieapi.databinding.MovieLayoutBinding

class MovieAdapter:RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var movieList = ArrayList<result>()

    fun setMovieList(movieList:List<result>){
        this.movieList=movieList as ArrayList<result> /* = java.util.ArrayList<com.example.movieapi.data.result> */
        notifyDataSetChanged()
    }

    class MovieViewHolder(val binding: MovieLayoutBinding):RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            MovieLayoutBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load("https://image.tmdb.org/t/p/w500"+movieList[position].poster_path)
            .into(holder.binding.movieImage)
        holder.binding.movieName.text=movieList[position].title

        Log.d("MovieName",movieList[position].title.toString())
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}