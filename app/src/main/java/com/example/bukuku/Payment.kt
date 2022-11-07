package com.example.bukuku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlin.math.sign

class Payment : AppCompatActivity(), IVolley, View.OnClickListener{
    override fun onResponse(response: String) {
        //Show Toast
        Toast.makeText(this@Payment,""+response,Toast.LENGTH_SHORT).show()
    }

    private lateinit var back: Button
    private lateinit var backToHomepage: Button
    private lateinit var profile: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        back = findViewById(R.id.back)
        backToHomepage = findViewById(R.id.backToHomepage)
        profile = findViewById(R.id.profile)
    }

    override fun OnClick(p0: View){
        when(p0.id){
            R.id.profile -> {
                val intentProfile = Intent(this@Payment, Profile::class.java)
                startActivity(intentProfile)
            }
            R.id.back -> {
                val intentBack = Intent(this@Payment, CheckOut::class.java)
                startActivity(intentBack)
            }
            R.id.backToHomepage -> {
                val intentBacktoHomepage = Intent(this@Payment, Homepage::class.java)
                startActivity(intentBacktoHomepage)
            }
        }
    }
}