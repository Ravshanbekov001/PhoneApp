package com.example.phoneapp

import Models.Parameters
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.example.phoneapp.saveData.AppCache
import com.example.phoneapp.saveData.click
import kotlinx.android.synthetic.main.activity_add_phone.*

class AddPhone : AppCompatActivity() {

    var phoneNames = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_phone)

        //Action Bar
        supportActionBar?.title = "Add phone"
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // Action Bar end

        val models = intent.getStringExtra("key")


        actionBarTitle()

        AppCache.init(this)

        add.setOnClickListener {
            val name = phone_name.text.toString().trim()
            val features = phone_features.text.toString().trim()

            if (name != "" && features != "") {
                val list = AppCache.objectString
                list.add(Parameters(models!!, name, features))
                AppCache.objectString = list
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Fill in the fields!", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun actionBarTitle() {
        when (click.count) {
            1 -> {
                supportActionBar?.title = "iPhone"
            }
            2 -> {
                supportActionBar?.title = "Samsung"
            }
            3 -> {
                supportActionBar?.title = "Mi"
            }
            4 -> {
                supportActionBar?.title = "Sony"
            }
            5 -> {
                supportActionBar?.title = "Huawei"
            }
            6 -> {
                supportActionBar?.title = "Artel"
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}







