package com.example.bukuku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlin.math.sign

class Payment : AppCompatActivity(), View.OnClickListener{


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

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}