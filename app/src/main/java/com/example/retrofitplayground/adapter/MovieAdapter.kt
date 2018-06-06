package com.example.retrofitplayground.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.retrofitplayground.MovieDao
import com.example.retrofitplayground.R
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var items: List<MovieDao> = listOf()

    fun setItems(newItems: List<MovieDao>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.onBindData(items[position])
    }

    inner class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun onBindData(model: MovieDao?) {
            Glide.with(itemView.context)
                .load(model?.imageUrl)
                .into(itemView.imgMovie)
        }
    }
}