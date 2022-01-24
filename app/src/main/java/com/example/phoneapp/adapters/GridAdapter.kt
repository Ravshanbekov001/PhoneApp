package com.example.phoneapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.phoneapp.R
import kotlinx.android.synthetic.main.grid_item.view.*

class GridAdapter(context: Context, val list: List<String>) :
    ArrayAdapter<String>(context, R.layout.grid_item, list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val itemView: View

        if (convertView == null) {
            itemView =
                LayoutInflater.from(parent.context).inflate(R.layout.grid_item, parent, false)
        } else {
            itemView = convertView
        }

        itemView.txt_grid_item.text = list[position]

        return itemView
    }
}