package com.example.phoneapp

import Models.Parameters
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.phoneapp.adapters.ListAdapter
import com.example.phoneapp.saveData.AppCache
import com.example.phoneapp.saveData.click
import kotlinx.android.synthetic.main.activity_selected_phone.*

class SelectedPhone : AppCompatActivity() {

    lateinit var list: List<Parameters>
    lateinit var listAdapter: ListAdapter
    lateinit var models: ArrayList<Parameters>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selected_phone)


        supportActionBar?.show()
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        actionBarTitle2()

        models = ArrayList()

        AppCache.init(this)
        list = AppCache.objectString

        for (item in list) {
            if (supportActionBar?.title == item.model) {
                models.add(item)
            }
        }


        listAdapter = ListAdapter(this, models)
        list_view.adapter = listAdapter


        list_view.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, AboutPhone::class.java)
            intent.putExtra("position", position)
            startActivity(intent)
        }

    }

    private fun actionBarTitle2() {
        when (click.count) {
            0 -> {
                supportActionBar?.title = "iPhone"
            }
            1 -> {
                supportActionBar?.title = "Samsung"
            }
            2 -> {
                supportActionBar?.title = "Mi"
            }
            3 -> {
                supportActionBar?.title = "Sony"
            }
            4 -> {
                supportActionBar?.title = "Huawei"
            }
            5 -> {
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