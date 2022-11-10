package com.example.bukuku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class NewPassword : AppCompatActivity(), View.OnClickListener {
    private lateinit var back: Button
    private lateinit var resetPassword: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_password)

        back = findViewById(R.id.registerNow)
        resetPassword = findViewById(R.id.resetPassword)
    }

    override fun onClick(p0: View) {
        when(p0.id){
            R.id.back ->{
                val intentBack = Intent(this@NewPassword, CheckEmail::class.java)
                //masukin pw baru
                val intentResetPassword = Intent(this@NewPassword, SignIn::class.java)
            }
        }
    }
}