package com.example.bukuku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class VerifyEmail : AppCompatActivity(), View.OnClickListener {
    private lateinit var back: Button
    private lateinit var openEmail: Button
    private lateinit var skipConfirm: Button
    private lateinit var tryAnother: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify_email)

        back = findViewById(R.id.back)
        openEmail = findViewById(R.id.openEmail)
        skipConfirm = findViewById(R.id.skipConfirm)
        tryAnother = findViewById(R.id.tryAnother)
    }

    override fun onClick(p0: View) {
        when(p0.id){
            R.id.back ->{
                val intentBack = Intent(this@VerifyEmail, Register::class.java)
                startActivity(intentBack)
            }
            R.id.openEmail ->{
                val intentOpenEmail = Intent(this@VerifyEmail, SignIn::class.java)
                startActivity(intentOpenEmail)
            }
            R.id.skipConfirm ->{
                val intentSkip = Intent(this@VerifyEmail, SignIn::class.java)
                startActivity(intentSkip)
            }
            R.id.tryAnother ->{
                val intentTry = Intent(this@VerifyEmail, Register::class.java)
                startActivity(intentTry)
            }
        }
    }
}