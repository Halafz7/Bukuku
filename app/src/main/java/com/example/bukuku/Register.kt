package com.example.bukuku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlin.math.sign

class Register : AppCompatActivity(),IVolley, View.OnClickListener {
    override fun onResponse(response: String) {
        //Show Toast
        Toast.makeText(this@Register,""+response,Toast.LENGTH_SHORT).show()
    }

    private lateinit var registerNow: Button
    private lateinit var signInRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        registerNow = findViewById(R.id.registerNow)
        registerNow.setOnClickListener{
            MyVolleyRequest.getInstance(this@Register, this@Register)
                .postRequest("https://eowpkjl19iypcej.m.pipedream.net")
        }

        signInRegister = findViewById(R.id.signInRegister)
        signInRegister.setOnClickListener(this)
    }

    override fun onClick(p0: View) {
        when(p0.id){
            R.id.registerNow ->{
                val intentDaftar = Intent(this@Register, SignIn::class.java)
                startActivity(intentDaftar)
            }
            R.id.signInRegister ->{
                val intentMasuk = Intent(this@Register, SignIn::class.java)
                startActivity(intentMasuk)
            }
        }

    }
}