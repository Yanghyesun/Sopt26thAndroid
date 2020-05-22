package com.hyesun.sopt26thandroid.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RequestToServer {
    private const val BASE_URL = "http://13.209.144.115:3333/"
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val service: NetworkService = retrofit.create(NetworkService::class.java)
}