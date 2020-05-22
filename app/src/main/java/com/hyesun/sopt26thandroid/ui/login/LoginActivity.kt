package com.hyesun.sopt26thandroid.ui.login

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import com.hyesun.sopt26thandroid.R
import com.hyesun.sopt26thandroid.data.RequestLogin
import com.hyesun.sopt26thandroid.data.ResponseLogin
import com.hyesun.sopt26thandroid.network.RequestToServer
import com.hyesun.sopt26thandroid.ui.signup.SignUpActivity
import com.hyesun.sopt26thandroid.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    val REQUEST_CODE=1000
    val requestToServer = RequestToServer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        txt_signup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivityForResult(intent,REQUEST_CODE)
        }

        btn_login.setOnClickListener {
            val bodyData =RequestLogin(
                id = edt_login_id.text.toString(),
                password = edt_login_pw.text.toString()
            )
                requestToServer.service.requestSignIn(bodyData)
                    .enqueue(object : Callback<ResponseLogin>{
                        override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {

                        }

                        override fun onResponse(
                            call: Call<ResponseLogin>,
                            response: Response<ResponseLogin>
                        ) {
                            if(response.isSuccessful){
                                Toast.makeText(this@LoginActivity,"로그인 성공",Toast.LENGTH_LONG)
                                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                                startActivity(intent)
                                finish()
                            }else{
                                Toast.makeText(this@LoginActivity,"${response.body()!!.message}",Toast.LENGTH_LONG)
                            }
                        }
                    })

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==REQUEST_CODE){
            if(resultCode==Activity.RESULT_OK){
                edt_login_id.text = Editable.Factory.getInstance().newEditable(data?.getStringExtra("id"))
                edt_login_pw.text = Editable.Factory.getInstance().newEditable(data?.getStringExtra("pw"))
            }
        }
    }
}
