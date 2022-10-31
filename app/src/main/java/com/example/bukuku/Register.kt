package com.example.bukuku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlin.math.sign

class Register : AppCompatActivity(), View.OnClickListener {

    private lateinit var registernow: Button
    private lateinit var signinregister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        registernow = findViewById(R.id.registernow)
        registernow.setOnClickListener(this)

        signinregister = findViewById(R.id.signinregister)
        signinregister.setOnClickListener(this)
    }

    override fun onClick(p0: View) {
        when(p0.id){
            R.id.registernow ->{
                val intentDaftar = Intent(this@Register, SignIn::class.java)
                startActivity(intentDaftar)
            }
            R.id.signinregister ->{
                val intentMasuk = Intent(this@Register, SignIn::class.java)
                startActivity(intentMasuk)
            }
        }

    }
}