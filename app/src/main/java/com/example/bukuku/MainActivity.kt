package com.example.bukuku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.Button
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnRegister : Button
    private lateinit var btnSignIn: Button
    private lateinit var btnSignInGoogle : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRegister = findViewById(R.id.btnRegister)
        btnRegister.setOnClickListener(this)

        btnSignIn = findViewById(R.id.btnSignIn)
        btnSignIn.setOnClickListener(this)

        btnSignInGoogle = findViewById(R.id.btnSignInGoogle)
        btnSignInGoogle.setOnClickListener(this)

    }

    override fun onClick(p0: View) {
        when(p0.id){
            R.id.btnRegister ->{
                val intentBiasa = Intent(this@MainActivity, Register::class.java)
                startActivity(intentBiasa)
            }
            R.id.btnSignIn ->{
                val intentBiasa2 = Intent(this@MainActivity, SignIn::class.java)
                startActivity(intentBiasa2)
            }
            R.id.btnSignInGoogle ->{
                val intentBiasa3 = Intent(this@MainActivity, SignIn::class.java)
                startActivity(intentBiasa3)
            }
        }
    }
}