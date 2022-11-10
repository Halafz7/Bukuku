package com.example.bukuku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Profile : AppCompatActivity(), View.OnClickListener {
    private lateinit var back: Button
    private lateinit var editProfile: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        back = findViewById((R.id.back))
        editProfile = findViewById(R.id.editProfile)
    }
    override fun onClick(p0: View){
        when(p0.id){
            R.id.back ->{
                val intentBack = Intent(this@Profile, Homepage::class.java)
                startActivity(intentBack)
            }
            R.id.editProfile ->{
                val intentEdit = Intent(this@Profile, EditProfile::class.java)
                startActivity(intentEdit)
            }
        }
    }
}