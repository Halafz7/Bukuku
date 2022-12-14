package com.example.bukuku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class CheckEmail : AppCompatActivity(), View.OnClickListener {
    private lateinit var back: Button
    private lateinit var openEmail: Button
    private lateinit var skipConfirm: Button
    private lateinit var tryAnother: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_email)

        back = findViewById(R.id.back)
        openEmail = findViewById(R.id.openEmail)
        skipConfirm = findViewById(R.id.skipConfirm)
        tryAnother = findViewById(R.id.tryAnother)
    }

    override fun onClick(p0: View) {
        when(p0.id){
            R.id.back ->{
                val intentBack = Intent(this@CheckEmail, ForgotPassword::class.java)
                startActivity(intentBack)
            }
            R.id.openEmail ->{
                val intentOpenEmail = Intent(this@CheckEmail, NewPassword::class.java)
                startActivity(intentOpenEmail)
            }
            R.id.skipConfirm ->{
                val intentSkip = Intent(this@CheckEmail, SignIn::class.java)
                startActivity(intentSkip)
            }
            R.id.tryAnother ->{
                val intentTry = Intent(this@CheckEmail, ForgotPassword::class.java)
                startActivity(intentTry)
            }
        }
    }
}