package com.example.bukuku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.widget.MenuPopupWindow

class Homepage : AppCompatActivity(), IVolley, View.OnClickListener {
    override fun onResponse(response: String) {
        //Show Toast
        Toast.makeText(this@Homepage,""+response, Toast.LENGTH_SHORT).show()
    }

    private lateinit var buku1: Button
    private lateinit var buku2: Button
    private lateinit var buku3: Button
    private lateinit var buku4: Button
    private lateinit var profile: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)
        buku1 = findViewById(R.id.book1)
        buku2 = findViewById(R.id.book2)
        buku3 = findViewById(R.id.book3)
        buku4 = findViewById(R.id.book4)
        profile = findViewById(R.id.profile)
    }

    override fun onClick(p0: View) {
        when (p0.id) {
            R.id.profile -> {
                val intentProfile = Intent(this@Homepage, Profile::class.java)
                startActivity(intentProfile)
            }
            R.id.book1 -> {
                val intentBook = Intent(this@Homepage, BookInformation::class.java)
                startActivity(intentBook)
            }
            R.id.book2 -> {
                val intentBook = Intent(this@Homepage, BookInformation::class.java)
                startActivity(intentBook)
            }
            R.id.book3 -> {
                val intentBook = Intent(this@Homepage, BookInformation::class.java)
                startActivity(intentBook)
            }
            R.id.book4 -> {
                val intentBook = Intent(this@Homepage, BookInformation::class.java)
                startActivity(intentBook)
            }
            }
        }

    }
//