package com.example.bukuku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class BookInformation : AppCompatActivity(), IVolley, View.OnClickListener {
    override fun onResponse(response: String) {
        //Show Toast
        Toast.makeText(this@BookInformation,""+response, Toast.LENGTH_SHORT).show()
    }

    private lateinit var back: Button
    private lateinit var addToCart: Button
    private lateinit var profile: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_information)

        addToCart = findViewById(R.id.addToCart)
        back = findViewById(R.id.back)
        profile = findViewById(R.id.profile)
    }

    override fun onClick(p0: View) {
        when(p0.id){
            R.id.profile -> {
                val intentProfile = Intent(this@BookInformation, Profile::class.java)
                startActivity(intentProfile)
            }
            R.id.addToCart ->{
                val intentCart = Intent(this@BookInformation, MyCart::class.java)
                startActivity(intentCart)
            }
            R.id.back ->{
                val intentBack = Intent(this@BookInformation, Homepage::class.java)
                startActivity(intentBack)
            }
        }

    }
}