package com.example.retrofitplayground

import retrofit2.Call
import retrofit2.http.GET

interface MovieApi {

    @GET("movie")
    fun getListMovie(): Call<ListMovieDao>
}