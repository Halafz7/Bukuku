package com.example.bukuku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class EditProfile : AppCompatActivity(), View.OnClickListener {
    private lateinit var back: Button
    private lateinit var saveChange: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        back = findViewById(R.id.back)
        saveChange = findViewById(R.id.saveChange)
    }

    override fun onClick(p0: View?) {
        when(p0.id){
            //ke hlm profil tanpa menyimpan perubahan profil
            R.id.registerNow ->{
                val intentBack = Intent(this@EditProfile, Profile::class.java)
                startActivity(intentBack)
            }
            //ke hlm profil setelah menyimpan perubahan profil
            R.id.saveChange ->{
                val intentSaveChange = Intent(this@EditProfile, Profile::class.java)
                startActivity(intentSaveChange)
            }
        }
    }
}