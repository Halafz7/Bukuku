package com.example.bukuku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.NoConnectionError
import com.android.volley.TimeoutError
import com.android.volley.VolleyError
import org.json.JSONArray
import org.json.JSONObject

class Register : AppCompatActivity(),IVolley, View.OnClickListener{
    override fun onResponse(response: JSONObject) {
        //Show Toast
        Toast.makeText(this@Register, "Registrasi Berhasil \n Silahkan Cek Email Anda", Toast.LENGTH_LONG).show()
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
            var jsonObject = JSONObject()
            jsonObject.put("username", fieldUsername.text.toString())
            jsonObject.put("email", fieldEmail.text.toString())
            jsonObject.put("password", fieldPassword.text.toString())

            MyVolleyRequest.getInstance(this@Register, this@Register)
                .registerRequest("https://bejobarokah.my.id:8443/auth/register", jsonObject)
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

    override fun onErrorResponse(error: VolleyError) {
        if(error is TimeoutError || error is NoConnectionError){
            Toast.makeText(this@Register, "Koneksi Bermasalah", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this@Register, "Registrasi Gagal", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onArrayResponse(response: JSONArray) {
        Toast.makeText(this@Register, "How?", Toast.LENGTH_LONG).show()
    }
}