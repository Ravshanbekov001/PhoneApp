package com.example.phoneapp

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.phoneapp.adapters.GridAdapter
import com.example.phoneapp.saveData.click
import kotlinx.android.synthetic.main.activity_phones.*
import kotlinx.android.synthetic.main.activity_phones.grid_view
import kotlinx.android.synthetic.main.grid_item.*
import kotlinx.android.synthetic.main.list_item.*


class Phones : AppCompatActivity() {

    lateinit var listPhones: ArrayList<String>
    lateinit var gridAdapter: GridAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phones)

        supportActionBar?.title = "Phones"
        supportActionBar?.show()
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        loadData()

        gridAdapter = GridAdapter(this, listPhones)
        grid_view.adapter = gridAdapter

        grid_view.setOnItemClickListener { parent, view, position, id ->
            startActivity(Intent(this, SelectedPhone::class.java))
            click.count = position

        }
    }

    private fun loadData() {

        listPhones = ArrayList()

        listPhones.add("iPhone")
        listPhones.add("Samsung")
        listPhones.add("Mi")
        listPhones.add("Sony")
        listPhones.add("Huawei")
        listPhones.add("Artel")

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}

