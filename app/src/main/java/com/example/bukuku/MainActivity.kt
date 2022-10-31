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

    private lateinit var btnregister : Button
    private lateinit var btnsignin : Button
    private lateinit var btnsigningoogle : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url = "https://bukuku.free.beeceptor.com"

        btnregister = findViewById(R.id.btnregister)
        btnregister.setOnClickListener(this)

        btnsignin = findViewById(R.id.btnsignin)
        btnsignin.setOnClickListener(this)

        btnsigningoogle = findViewById(R.id.btnsigningoogle)
        btnsigningoogle.setOnClickListener(this)

    }

    override fun onClick(p0: View) {
        when(p0.id){
            R.id.btnregister ->{
                val intentBiasa = Intent(this@MainActivity, Register::class.java)
                startActivity(intentBiasa)
            }
            R.id.btnsignin ->{
                val intentBiasa2 = Intent(this@MainActivity, SignIn::class.java)
                startActivity(intentBiasa2)
            }
            R.id.btnsigningoogle ->{
                val intentBiasa3 = Intent(this@MainActivity, SignIn::class.java)
                startActivity(intentBiasa3)
            }
        }
    }
}