package com.example.phoneapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.phoneapp.saveData.AppCache
import kotlinx.android.synthetic.main.activity_about_phone.*

class AboutPhone : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_phone)

        //Action Bar
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Selected"
        // Action Bar end

        AppCache.init(this)
        val list = AppCache.objectString

        val position = intent.getIntExtra("position", 0)
        supportActionBar?.title = list[position].phone_name
        about_phone.text = list[position].phone_features

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}