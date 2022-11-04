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

class MainActivity : AppCompatActivity(), IVolley, View.OnClickListener {
    override fun onResponse(response: String) {
        //Show Toast
        Toast.makeText(this@MainActivity,""+response,Toast.LENGTH_SHORT).show()
    }

    private lateinit var btnregister : Button
    private lateinit var btnsignin : Button
    private lateinit var btnsigningoogle : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnregister = findViewById(R.id.btnregister)
        btnregister.setOnClickListener{
            MyVolleyRequest.getInstance(this@MainActivity, this@MainActivity)
                .getRequest("https://bukuku.free.beeceptor.com")
        }

        btnsignin = findViewById(R.id.btnsignin)
        btnsignin.setOnClickListener{
            MyVolleyRequest.getInstance(this@MainActivity, this@MainActivity)
                .getRequest("https://bukuku.free.beeceptor.com")
        }

        btnsigningoogle = findViewById(R.id.btnsigningoogle)
        btnsigningoogle.setOnClickListener{
            MyVolleyRequest.getInstance(this@MainActivity, this@MainActivity)
                .getRequest("https://bukuku.free.beeceptor.com")
        }

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