package com.example.bukuku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlin.math.sign

class MyCart : AppCompatActivity(),IVolley, View.OnClickListener {
    override fun onResponse(response: String) {
        //Show Toast
        Toast.makeText(this@MyCart,""+response,Toast.LENGTH_SHORT).show()
    }

    private lateinit var back2: Button
    private lateinit var checkout: Button
    private lateinit var checkbox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_item)

        back2 = findViewById(R.id.back)
        back2.setOnClickListener {
            MyVolleyRequest.getInstance(this@MyCart, this@MyCart).getRequest("https://bukuku.free.beeceptor.com/register")
        }
        checkout = findViewById(R.id.checkout)
        checkout.setOnClickListener(this)

        checkbox = findViewById(R.id.checkbox)
        checkbox.setonChe

//        class MyActivity : Activity() {
//            override fun onCreate(icicle: Bundle?) {
//                super.onCreate(icicle)
//                setContentView(R.layout.content_layout_id)
//                val checkBox = findViewById<View>(R.id.checkbox_id) as CheckBox
//                if (checkBox.isChecked) {
//                    checkBox.isChecked = false
//                }
//            }
//        }
    }
}