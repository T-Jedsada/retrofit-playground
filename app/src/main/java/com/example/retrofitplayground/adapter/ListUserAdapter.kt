package com.example.retrofitplayground.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.retrofitplayground.R
import kotlinx.android.synthetic.main.item_user.view.*

// case 3
typealias ActionItemClick3 = () -> Unit

interface UserAdapterListener {
    fun onItemClick()
}

class ListUserAdapter(
    private var actionItemClick1: () -> Unit,
    private val callback: UserAdapterListener
) : RecyclerView.Adapter<ListUserAdapter.UserViewHolder>() {

    var items: List<String> = listOf()

    // case 2
    var actionIemClick2: (() -> Unit)? = null

    var actionItemClick3: ActionItemClick3? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
        UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.onBindData(items[position])
    }

    inner class UserViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun onBindData(str: String) {
            view.apply {
                tvName.text = str
                setOnClickListener {
                    // How to use
                    // case 1:
                    actionItemClick1.invoke()

                    // case 2:
                    actionIemClick2?.invoke()

                    // case 3:
                    actionItemClick3?.invoke()

                    callback.onItemClick()
                }
            }
        }
    }
}

fun main() {
    val listUserAdapter = ListUserAdapter(
        actionItemClick1 = {
            // TODO : something
        },
        callback = object : UserAdapterListener {
            override fun onItemClick() {
                // TODO : something
            }
        }
    ).apply {
        actionIemClick2 = {
            // TODO : something
        }

        actionItemClick3 = {
            // TODO : something
        }
    }
}