package com.example.bukuku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class SignIn : AppCompatActivity(), View.OnClickListener {

    private lateinit var masukhomepage: Button
    private lateinit var lupapassword: Button
    private lateinit var btnregister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        masukhomepage = findViewById(R.id.masukhomepage)
        masukhomepage.setOnClickListener(this)

        lupapassword = findViewById(R.id.lupapassword)
        lupapassword.setOnClickListener(this)

        btnregister = findViewById(R.id.btnregister)
        btnregister.setOnClickListener(this)
    }

    override fun onClick(p0: View) {
        when (p0.id) {
            R.id.masukhomepage -> {
                val intentHomepage = Intent(this@SignIn, Homepage::class.java)
                startActivity(intentHomepage)
            }
            R.id.lupapassword -> {
                val intentForget = Intent(this@SignIn, ForgotPassword::class.java)
                startActivity(intentForget)
            }
            R.id.btnregister ->{
                val intentDaftar = Intent(this@SignIn, Register::class.java)
                startActivity(intentDaftar)
            }
        }

    }
}