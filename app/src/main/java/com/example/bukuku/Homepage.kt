package com.example.bukuku

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import com.android.volley.VolleyError
import org.json.JSONArray
import org.json.JSONObject

class Homepage : AppCompatActivity(), IVolley, View.OnClickListener {
    override fun onArrayResponse(response: JSONArray) {
        try{
            var arrayBuku = response
            for(i in 0 until 1){
                var jsonObject = arrayBuku.getJSONObject(i)
                fieldJudul1.setText(jsonObject.getString("judul"))
            }
        }catch (e: Exception){
            Toast.makeText(this@Homepage,"???", Toast.LENGTH_SHORT).show()
        }
    }

    private lateinit var buku1: ImageView
    private lateinit var buku2: ImageView
    private lateinit var buku3: ImageView
    private lateinit var buku4: ImageView
    private lateinit var profile: ImageView
    private lateinit var fieldJudul1: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        buku1 = findViewById(R.id.book1)
        buku2 = findViewById(R.id.book2)
        buku3 = findViewById(R.id.book3)
        buku4 = findViewById(R.id.book4)
        profile = findViewById(R.id.profile)
        fieldJudul1 = findViewById(R.id.fieldJudul1)

        MyVolleyRequest.getInstance(this@Homepage, this@Homepage)
            .getArrayRequest("https://bejobarokah.my.id:8443/buku")

        val button = findViewById<Button>(R.id.clickMenu)
        button.setOnClickListener {
            val popupMenu: androidx.appcompat.widget.PopupMenu = androidx.appcompat.widget.PopupMenu(this,button)
            popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)
//            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener {
//
//        }
        }
    }

    //private fun PopupMenu.setOnMenuItemClickListener(function: (MenuItem) -> Unit) {
    private fun PopupMenu.setOnMenuItemClickListener(p0: View){
        when(p0.id){
            R.id.action_homepage -> {
                val intentMenuHomepage = Intent(this@Homepage, Homepage::class.java)
                startActivity(intentMenuHomepage)
            }
            R.id.action_my_cart -> {
                val intentMenuMyCart = Intent(this@Homepage, MyCart::class.java)
                startActivity(intentMenuMyCart)
            }
            R.id.action_my_book -> {
                val intentMenuMyBook = Intent(this@Homepage, MyBook::class.java)
                startActivity(intentMenuMyBook)
            }
            R.id.action_history -> {
                val intentMenuHistory = Intent(this@Homepage, History::class.java)
                startActivity(intentMenuHistory)
            }
            R.id.action_add_to_catalogue-> {
                val intentMenuAddToCatalogue = Intent(this@Homepage, AddToCatalogue::class.java)
                startActivity(intentMenuAddToCatalogue)
            }
        }
//        val id = MenuItem.getItemId
//        if (id == R.id.homepage){
//            val intentMenuHomepage = Intent(this@Homepage, Homepage::class.java)
//            startActivity(intentMenuHomepage)
//        }
//        if (id == R.id.cart){
//            val intentMenuCart = Intent(this@Homepage, MyCart::class.java)
//            startActivity(intentMenuCart)
//        }
//        if (id == R.id.book){
//            val intentMenuBook = Intent(this@Homepage, MyBook::class.java)
//            startActivity(intentMenuBook)
//        }
//        if (id == R.id.history){
//            val intentMenuHistory = Intent(this@Homepage, History::class.java)
//            startActivity(intentMenuHistory)
//        }
//        if (id == R.id.addToCatalogue){
//            val intentMenuAddToCatalogue = Intent(this@Homepage, AddToCatalogue::class.java)
//            startActivity(intentMenuAddToCatalogue)
//        }
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

        override fun onErrorResponse(error: VolleyError) {
            Toast.makeText(this@Homepage,error.toString(), Toast.LENGTH_LONG).show()
        }

        override fun onResponse(response: JSONObject) {
            //Show Toast
            Toast.makeText(this@Homepage,"How?", Toast.LENGTH_SHORT).show()
        }

    }



//