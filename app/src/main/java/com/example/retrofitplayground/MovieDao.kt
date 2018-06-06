package com.example.retrofitplayground

import com.google.gson.annotations.SerializedName

data class MovieDao(
    @SerializedName("title") val title: String? = null,
    @SerializedName("image_url") val imageUrl: String? = null,
    @SerializedName("overview") val overview: String? = null
)

data class ListMovieDao(
    @SerializedName("results") val listMovie: List<MovieDao>? = null
)