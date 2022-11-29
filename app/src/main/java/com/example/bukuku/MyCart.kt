package com.example.bukuku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import com.android.volley.VolleyError
import org.json.JSONArray
import org.json.JSONObject

class MyCart : AppCompatActivity(),IVolley, View.OnClickListener {
    override fun onResponse(response: JSONObject) {
        //Show Toast
        Toast.makeText(this@MyCart,""+response,Toast.LENGTH_SHORT).show()
    }

    override fun onArrayResponse(response: JSONArray) {
        TODO("Not yet implemented")
    }

    private lateinit var back: Button
    private lateinit var checkout: Button
    private lateinit var checkbox1: CheckBox
    private lateinit var checkbox2: CheckBox
    private lateinit var checkbox3: CheckBox
    private lateinit var checkbox4: CheckBox
    private lateinit var profile: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_cart)

        back = findViewById(R.id.back)

        checkout = findViewById(R.id.checkout)

        checkbox1 = findViewById(R.id.checkbox1)
        checkbox2 = findViewById(R.id.checkbox2)
        checkbox3 = findViewById(R.id.checkbox3)
        checkbox4 = findViewById(R.id.checkbox4)
        profile = findViewById(R.id.profile)
    }
    override fun onClick(p0: View) {
        when(p0.id){
            R.id.profile -> {
                val intentProfile = Intent(this@MyCart, Profile::class.java)
                startActivity(intentProfile)
            }
            R.id.back ->{
                val intentBack = Intent(this@MyCart, BookInformation::class.java)
                startActivity(intentBack)
            }
            R.id.checkout ->{
                val intentCheckOut = Intent(this@MyCart, CheckOut::class.java)
                startActivity(intentCheckOut)
            }
            //belum ada untuk checkboxnya
        }
    }

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

    override fun onErrorResponse(error: VolleyError) {
        TODO("Not yet implemented")
    }
}