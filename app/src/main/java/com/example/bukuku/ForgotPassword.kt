package com.example.bukuku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class ForgotPassword : AppCompatActivity(), View.OnClickListener {

    private lateinit var cekemail: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        cekemail = findViewById(R.id.cekemail)
        cekemail.setOnClickListener(this)
    }

    override fun onClick(p0: View) {
        when(p0.id){
            R.id.cekemail ->{
                val intentCekEmail = Intent(this@ForgotPassword, CheckEmail::class.java)
                startActivity(intentCekEmail)
            }
        }
    }
}