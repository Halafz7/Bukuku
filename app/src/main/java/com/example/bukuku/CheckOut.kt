package com.example.bukuku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class CheckOut : AppCompatActivity(), IVolley, View.OnClickListener {
    override fun onResponse(response: String) {
        Toast.makeText(this@CheckOut,""+response,Toast.LENGTH_SHORT).show()
    }

    private lateinit var back: Button
    private lateinit var placeOrder: Button
    private lateinit var profile: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_out)

        back = findViewById(R.id.back)
        placeOrder = findViewById(R.id.placeOrder)
        profile = findViewById(R.id.profile)
    }

    override fun onClick(p0: View) {
        when(p0.id) {
            R.id.profile -> {
                val intentProfile = Intent(this@CheckOut, Profile::class.java)
                startActivity(intentProfile)
            }
            R.id.back -> {
                val intentBack = Intent(this@CheckOut, MyCart::class.java)
                startActivity(intentBack)
            }
            R.id.placeOrder -> {
                val intentPlaceOrder = Intent(this@CheckOut, Payment::class.java)
                startActivity(intentPlaceOrder)
            }
        }
    }
}