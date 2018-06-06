package com.example.retrofitplayground

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitManager {

    private fun createRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://workshopup.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getMovieApi() = createRetrofit().create(MovieApi::class.java)
}