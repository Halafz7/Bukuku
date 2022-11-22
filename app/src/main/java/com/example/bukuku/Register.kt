package com.example.bukuku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import kotlin.math.sign

class Register : AppCompatActivity(),IVolley, View.OnClickListener {
    override fun onResponse(response: String) {
        //Show Toast
        Toast.makeText(this@Register,"Registrasi berhasil"+response,Toast.LENGTH_SHORT).show()
    }

    private lateinit var registerNow: Button
    private lateinit var signInRegister: Button
    private lateinit var fieldUsername: EditText
    private lateinit var fieldEmail: EditText
    private lateinit var fieldPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        fieldUsername = findViewById(R.id.fieldUsername)
        fieldEmail = findViewById(R.id.fieldEmail)
        fieldPassword = findViewById(R.id.filedPassword)

        registerNow = findViewById(R.id.registerNow)
        registerNow.setOnClickListener{
            MyVolleyRequest.getInstance(this@Register, this@Register)
                .postRegisterRequest("https://bejobarokah.my.id:8443/auth/register",
                    fieldUsername.text.toString(), fieldEmail.text.toString(), fieldPassword.text.toString())
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