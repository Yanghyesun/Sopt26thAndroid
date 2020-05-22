package com.hyesun.sopt26thandroid.ui.signup

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hyesun.sopt26thandroid.R
import com.hyesun.sopt26thandroid.data.RequestSignUp
import com.hyesun.sopt26thandroid.data.ResponseSignUp
import com.hyesun.sopt26thandroid.network.RequestToServer
import com.hyesun.sopt26thandroid.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_sign_up.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    val requestToServer = RequestToServer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btn_signup.setOnClickListener {
            val bodyData = RequestSignUp(
                id = edt_signup_id.text.toString(),
                password = edt_signup_pw.text.toString(),
                name = edt_signup_name.text.toString(),
                email = edt_signup_email.text.toString(),
                phone = edt_signup_phone.text.toString()
            )
            requestToServer.service.requestSignup(bodyData)
                .enqueue(
                    object : Callback<ResponseSignUp> {
                        override fun onFailure(call: Call<ResponseSignUp>, t: Throwable) {

                        }

                        override fun onResponse(
                            call: Call<ResponseSignUp>,
                            response: Response<ResponseSignUp>
                        ) {
                            if(response.isSuccessful){
                                Toast.makeText(this@SignUpActivity,"회원가입 성공",Toast.LENGTH_LONG)
                                val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
                                intent.putExtra("id",edt_signup_id.text.toString())
                                intent.putExtra("pw",edt_signup_pw.text.toString())
                                setResult(Activity.RESULT_OK,intent)
                                finish()
                            }else{
                                Toast.makeText(this@SignUpActivity,"${response.body()!!.message}",Toast.LENGTH_LONG)
                            }
                        }
                    }
                )

        }
    }
}
