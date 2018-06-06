package com.example.retrofitplayground

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.retrofitplayground.adapter.MovieAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val movieAdapter: MovieAdapter by lazy { MovieAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMovie?.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = movieAdapter
        }

        RetrofitManager.getMovieApi()
            .getListMovie()
            .enqueue(object : Callback<ListMovieDao> {
                override fun onResponse(call: Call<ListMovieDao>?, response: Response<ListMovieDao>?) {
                    if (response?.isSuccessful == true) {
                        movieAdapter.setItems(response.body()?.listMovie ?: listOf())
                    } else {
                        // TODO: handle message error
                    }
                }

                override fun onFailure(call: Call<ListMovieDao>?, t: Throwable?) {
                    t?.printStackTrace()
                }
            })
    }
}
