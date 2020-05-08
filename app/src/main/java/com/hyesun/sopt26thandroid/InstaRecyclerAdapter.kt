package com.hyesun.sopt26thandroid

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class InstaRecyclerAdapter(private val context: Context):RecyclerView.Adapter<InstaViewHolder>() {
    var data = listOf<InstaData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstaViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_home_insta,parent,false)
        return InstaViewHolder(view)
    }

    override fun getItemCount(): Int =data.size

    override fun onBindViewHolder(holder: InstaViewHolder, position: Int) {
        holder.bind(data[position])
    }
}