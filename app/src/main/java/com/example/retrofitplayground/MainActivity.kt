package com.example.retrofitplayground

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RetrofitManager.getGithubApi()
            .getListUserGithub("t-jedsada")
            .enqueue(object : Callback<List<ReposDao>> {
                override fun onFailure(call: Call<List<ReposDao>>?, t: Throwable?) {
                    t?.printStackTrace()
                }

                override fun onResponse(call: Call<List<ReposDao>>?, response: Response<List<ReposDao>>?) {
                    if (response?.isSuccessful == true) {
                        Log.d("POND", response.body()?.toString())
                    } else {
                        // TODO: handle message error
                    }
                }
            })
    }
}
