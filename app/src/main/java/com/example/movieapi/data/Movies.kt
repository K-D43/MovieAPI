package com.example.movieapi.data

data class Movies(
    val page: Int,
    val results: List<result>,
    val total_pages: Int,
    val total_results: Int
)
