package com.example.phoneapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        card_phones.setOnClickListener {
            startActivity(Intent(this, Phones::class.java))
        }

        card_add_phone.setOnClickListener {
            startActivity(Intent(this, PhoneTypes::class.java))
        }

    }
}