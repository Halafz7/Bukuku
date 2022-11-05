package com.example.bukuku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class SignIn : AppCompatActivity(),IVolley ,View.OnClickListener {
    override fun onResponse(response: String) {
        //Show Toast
        Toast.makeText(this@SignIn, ""+response,Toast.LENGTH_SHORT).show()
    }

    private lateinit var masukHomepage: Button
    private lateinit var lupaPassword: Button
    private lateinit var btnRegisterNow: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        masukHomepage = findViewById(R.id.masukHomepage)
        masukHomepage.setOnClickListener{
            MyVolleyRequest.getInstance(this@SignIn, this@SignIn)
                .getRequest("https://bukuku.free.beeceptor.com")
        }

        lupaPassword = findViewById(R.id.lupaPassword)
        lupaPassword.setOnClickListener(this)

        btnRegisterNow = findViewById(R.id.btnRegisterNow)
        btnRegisterNow.setOnClickListener(this)
    }

    override fun onClick(p0: View) {
        when (p0.id) {
            R.id.masukHomepage -> {
                val intentHomepage = Intent(this@SignIn, Homepage::class.java)
                startActivity(intentHomepage)
            }
            R.id.lupaPassword -> {
                val intentForget = Intent(this@SignIn, ForgotPassword::class.java)
                startActivity(intentForget)
            }
            R.id.btnRegisterNow ->{
                val intentDaftar = Intent(this@SignIn, Register::class.java)
                startActivity(intentDaftar)
            }
        }

    }
}