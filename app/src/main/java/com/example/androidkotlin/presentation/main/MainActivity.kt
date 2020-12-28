package com.example.androidkotlin.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidkotlin.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val mainViewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login_button.setOnClickListener{
            mainViewModel.onClickedLogin(login_edit.text.toString().trim(), password_edit.text.toString())
        }
      /*  mainViewModel.text.observe(this, Observer {
            value -> main_text.text = value
        })*/
    }
}