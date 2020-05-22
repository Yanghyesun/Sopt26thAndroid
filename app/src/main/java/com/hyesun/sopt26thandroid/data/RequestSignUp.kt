package com.hyesun.sopt26thandroid.data

data class RequestSignUp(
    val id: String,
    val password: String,
    val name: String,
    val email: String,
    val phone: String
)
data class ResponseSignUp(
    val status: Int,
    val success: Boolean,
    val message: String
)