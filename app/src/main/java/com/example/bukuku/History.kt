package com.example.bukuku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class History : AppCompatActivity(), View.OnClickListener {
    private lateinit var back: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        back = findViewById(R.id.back)
    }

    override fun onClick(p0: View) {
        when(p0.id){
            R.id.back ->{
                val intentBack = Intent(this@History, Homepage::class.java)
                startActivity(intentBack)
            }
        }
    }
}