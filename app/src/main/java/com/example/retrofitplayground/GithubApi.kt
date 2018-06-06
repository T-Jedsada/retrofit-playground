package com.example.retrofitplayground

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {

    @GET("users/{user}/repos")
    fun getListUserGithub(@Path("user") userName: String): Call<List<ReposDao>>
}