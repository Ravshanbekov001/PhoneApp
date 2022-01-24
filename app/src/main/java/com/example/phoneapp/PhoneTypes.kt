package com.example.phoneapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import com.example.phoneapp.saveData.click
import kotlinx.android.synthetic.main.activity_phone_types.*

class PhoneTypes : AppCompatActivity() {

    lateinit var phoneNames: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_types)

        //Action Bar
        supportActionBar?.title = "Phone types"
        supportActionBar?.show()
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // Action Bar end


        iPhone.setOnClickListener {
            startActivity(Intent(this, AddPhone::class.java).putExtra("key",
                txt_iPhone.text.toString()))
            click.count = 1

        }

        samsung.setOnClickListener {
            startActivity(Intent(this, AddPhone::class.java).putExtra("key",
                txt_samsung.text.toString()))
            click.count = 2
        }

        mi.setOnClickListener {
            startActivity(Intent(this, AddPhone::class.java).putExtra("key", txt_Mi.text.toString()))
            click.count = 3
        }

        sony.setOnClickListener {
            startActivity(Intent(this, AddPhone::class.java).putExtra("key",
                txt_sony.text.toString()))
            click.count = 4
        }

        huawei.setOnClickListener {
            startActivity(Intent(this, AddPhone::class.java).putExtra("key",
                txt_huawei.text.toString()))
            click.count = 5
        }

        artel.setOnClickListener {
            startActivity(Intent(this, AddPhone::class.java).putExtra("key",
                txt_artel.text.toString()))
            click.count = 6
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}