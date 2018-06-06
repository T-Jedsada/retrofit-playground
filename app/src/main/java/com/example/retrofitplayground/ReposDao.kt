package com.example.retrofitplayground

import com.google.gson.annotations.SerializedName

data class ReposDao(
    @SerializedName("id") val userId: Long? = null,
    @SerializedName("name") val reposName: String? = null,
    @SerializedName("full_name") val reposFullName: String? = null
)