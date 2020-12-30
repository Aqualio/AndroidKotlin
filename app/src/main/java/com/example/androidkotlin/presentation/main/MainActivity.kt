package com.example.androidkotlin.presentation.main

import android.app.ListActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.example.androidkotlin.R
import com.example.androidkotlin.presentation.status.AccountError
import com.example.androidkotlin.presentation.status.AccountSuccess
import com.example.androidkotlin.presentation.status.LoginError
import com.example.androidkotlin.presentation.status.LoginSuccess
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val mainViewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
      //  Log.d("DEBUT", "dab")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.loginLiveData.observe(this, Observer { it ->
            when(it){
                is LoginSuccess -> {
                    createListActivity()
                }
                LoginError -> {MaterialAlertDialogBuilder(this)
                .setTitle("Error")
                .setMessage("Account not in the Database")
                .setPositiveButton("OK"){
                    dialog, which -> dialog.dismiss()
                }
                .show()
                }
                AccountError -> {MaterialAlertDialogBuilder(this)
                .setTitle("Error")
                .setMessage("Account already in the Database")
                .setPositiveButton("OK"){
                    dialog, which -> dialog.dismiss()
                }
                .show()
                }
                is AccountSuccess -> {
                    createListActivity()
                }

            }
        })
        login_button.setOnClickListener{
            mainViewModel.onClickedLogin(login_edit.text.toString().trim(), password_edit.text.toString())
        }
        create_account_button.setOnClickListener{
            mainViewModel.onClickedCreateAccount(login_edit.text.toString().trim(), password_edit.text.toString())
        }

    }

    private fun createListActivity(){
        val intent = Intent(this, ListActivity::class.java)
        this.startActivity(intent)
    }
}