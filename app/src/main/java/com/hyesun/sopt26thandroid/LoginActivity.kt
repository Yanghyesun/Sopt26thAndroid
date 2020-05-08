package com.hyesun.sopt26thandroid

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    val REQUEST_CODE=1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        txt_signup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivityForResult(intent,REQUEST_CODE)
        }

        btn_login.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==REQUEST_CODE){
            if(resultCode==Activity.RESULT_OK){
                edt_login_email.text = Editable.Factory.getInstance().newEditable(data?.getStringExtra("email"))
                edt_login_pw.text = Editable.Factory.getInstance().newEditable(data?.getStringExtra("pw"))
            }
        }
    }
}
