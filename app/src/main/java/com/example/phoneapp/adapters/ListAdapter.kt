package com.example.phoneapp.adapters

import Models.Parameters
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.phoneapp.R
import kotlinx.android.synthetic.main.list_item.view.*

class ListAdapter(context: Context, val list: List<Parameters>) :
    ArrayAdapter<Parameters>(context, R.layout.list_item, list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val itemView: View

        if (convertView == null) {
            itemView =
                LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        } else {
            itemView = convertView
        }

        itemView.txt_list_item.text = list[position].phone_name

        return itemView
    }
}













