package com.example.bukuku

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.VolleyError
import org.json.JSONArray
import org.json.JSONObject

class SignIn : AppCompatActivity(), IVolley, View.OnClickListener {

    private lateinit var masukHomepage: Button
    private lateinit var lupaPassword: Button
    private lateinit var btnRegisterNow: Button
    private lateinit var fieldUsername: EditText
    private lateinit var fieldPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        fieldUsername = findViewById(R.id.fieldUsername)
        fieldPassword = findViewById(R.id.fieldPassword)

        masukHomepage = findViewById(R.id.masukHomepage)
        masukHomepage.setOnClickListener(this)


        lupaPassword = findViewById(R.id.lupaPassword)
        lupaPassword.setOnClickListener(this)

        btnRegisterNow = findViewById(R.id.btnRegisterNow)
        btnRegisterNow.setOnClickListener(this)
    }

    override fun onClick(p0: View) {
        when (p0.id) {
            R.id.masukHomepage -> {
                MyVolleyRequest.getInstance(this@SignIn, this@SignIn)
                    .authRequest("https://bejobarokah.my.id:8443/auth/login",
                    fieldUsername.text.toString(), fieldPassword.text.toString())
            }
            R.id.lupaPassword -> {
                val intentForget = Intent(this@SignIn, ForgotPassword::class.java)
                startActivity(intentForget)
            }
            R.id.btnRegisterNow ->{
                val intentDaftar = Intent(this@SignIn, Register::class.java)
                startActivity(intentDaftar)
            }
        }

    }

    override fun onResponse(response: JSONObject) {
        var token = response.getString("token")
        var userId = response.getString("userId")
        var pref = applicationContext.getSharedPreferences("BUKUKU_APP", Context.MODE_PRIVATE)
        pref.edit().putString("token",token).apply()
        pref.edit().putString("userId", userId).apply()

        val intentHomepage = Intent(this@SignIn, Homepage::class.java)
        startActivity(intentHomepage)
    }

    override fun onErrorResponse(error: VolleyError) {
        Toast.makeText(this@SignIn, error.toString(), Toast.LENGTH_LONG).show()
    }

    override fun onArrayResponse(response: JSONArray) {
        Toast.makeText(this@SignIn, "How?", Toast.LENGTH_LONG).show()
    }
}