package com.hyesun.sopt26thandroid

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btn_signup.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("email",edt_signup_email.text.toString())
            intent.putExtra("pw",edt_signup_pw.text.toString())
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
}
