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
    private lateinit var buku: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)
        buku = findViewById(R.id.book)
        buku.setOnClickListener {
            MyVolleyRequest.getInstance(this@Homepage, this@Homepage).getRequest("https://bukuku.free.beeceptor.com/homepage")
        }
    }

    override fun onClick(p0: View) {
        when (p0.id) {
            R.id.book -> {
                val intentHomepage = Intent(this@Homepage, BookInformation::class.java)
                startActivity(intentHomepage)
            }
            }
        }

    }
//