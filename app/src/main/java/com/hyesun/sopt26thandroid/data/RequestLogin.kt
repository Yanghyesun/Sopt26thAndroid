package com.hyesun.sopt26thandroid.data

data class RequestLogin(
    val id: String,
    val password: String
)
data class ResponseLogin(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: ResponseLoginData
)
data class ResponseLoginData(
    val jwt: String
)