package com.hyesun.sopt26thandroid.ui.home

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hyesun.sopt26thandroid.R
import com.hyesun.sopt26thandroid.data.InstaData

class InstaViewHolder(view: View):RecyclerView.ViewHolder(view) {
    val profile_img = view.findViewById<ImageView>(R.id.img_profile)
    val user_name = view.findViewById<TextView>(R.id.tv_username)
    val content_img = view.findViewById<ImageView>(R.id.img_contents)
    fun bind(data: InstaData){
        user_name.text = data.user_name
        Glide.with(itemView).load(data.profile_img).into(profile_img)
        Glide.with(itemView).load(data.content_img).into(content_img)
    }
}