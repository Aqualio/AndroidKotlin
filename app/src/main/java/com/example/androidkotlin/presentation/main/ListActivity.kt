package com.example.androidkotlin.presentation.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.androidkotlin.R
import com.example.androidkotlin.presentation.status.*
import com.example.androidkotlin.domain.entity.Skyrimraces
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.koin.android.ext.android.inject

class ListActivity: AppCompatActivity() {
    private val listViewModel : ListViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_activity)

        listViewModel.makeAPICall()
        listViewModel.apiLiveData.observe(this, Observer { it ->
            when(it){
                is APISuccess -> {
                    showList(it.charaList)
                    Log.d("CREATION", "caca")
                }
                APIError -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Error")
                        .setMessage("API couldn't be called")
                        .setPositiveButton("OK"){
                                dialog, which -> dialog.dismiss()
                        }
                        .show()
                }
            }
        })
    }

    private fun showList(characters: List<Skyrimraces>){
        val recyclerView = findViewById<View>(R.id.recycler_view) as RecyclerView
        recyclerView.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val listAdapter = ListAdapter(characters)
        recyclerView.adapter = listAdapter

    }
}