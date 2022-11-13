package com.example.bukuku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.widget.MenuPopupWindow

class Homepage : AppCompatActivity(), IVolley, View.OnClickListener {
    override fun onResponse(response: String) {
        //Show Toast
        Toast.makeText(this@Homepage,""+response, Toast.LENGTH_SHORT).show()
    }

    private lateinit var buku1: Button
    private lateinit var buku2: Button
    private lateinit var buku3: Button
    private lateinit var buku4: Button
    private lateinit var profile: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        buku1 = findViewById(R.id.book1)
        buku2 = findViewById(R.id.book2)
        buku3 = findViewById(R.id.book3)
        buku4 = findViewById(R.id.book4)
        profile = findViewById(R.id.profile)
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

    }



//