package com.hyesun.sopt26thandroid.network

import com.hyesun.sopt26thandroid.data.RequestLogin
import com.hyesun.sopt26thandroid.data.RequestSignUp
import com.hyesun.sopt26thandroid.data.ResponseLogin
import com.hyesun.sopt26thandroid.data.ResponseSignUp
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface NetworkService {
    //회원가입
    @POST("/user/signup")
    fun requestSignup(
        @Body body: RequestSignUp
    ): Call<ResponseSignUp>

    //로그인
    @POST("/user/signin")
    fun requestSignIn(
        @Body body: RequestLogin
    ):Call<ResponseLogin>
}