package com.example.androidkotlin.presentation.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidkotlin.R
import com.example.androidkotlin.domain.entity.Skyrimraces
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView



class ListAdapter(
    myDataset: List<Skyrimraces>
): RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    private val values = myDataset

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    class ViewHolder(
        var layout: View
        ): RecyclerView.ViewHolder(
            layout
        ) {
        // each data item is just a string in this case
        var txtHeader: TextView = layout.findViewById<View>(R.id.firstLine) as TextView
        }
        @NonNull
        @Override
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): ViewHolder {
            // create a new view
            val inflater: LayoutInflater = LayoutInflater.from(
                parent.getContext()
            )
            val v: View = inflater.inflate(R.layout.row_activity, parent, false)
            // set the view's size, margins, paddings and layout parameters
            return ViewHolder(v)
        }

        @SuppressLint("SetTextI18n")
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val currentRace: Skyrimraces = values[position]
            holder.txtHeader.text = currentRace.Name
        }

        override fun getItemCount(): Int {
            return values.size
        }


}