package com.example.androidkotlin.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidkotlin.domain.entity.User
import com.example.androidkotlin.domain.usecase.*
import kotlinx.coroutines.*


class MainViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
    ):ViewModel() {


    val loginLiveData: MutableLiveData<String> = MutableLiveData()

    init {
        text.value = "Texte LiveData"
    }


    fun onClickedLogin(emailUser: String, password: String) {
        viewModelScope.launch(Dispatchers.IO){

            val user = getUserUseCase.invoke(emailUser) // ADD PASSWORD HERE
          //  val user = getUserUseCase.invoke("test")
            if(user != null){

            }else{

            }
        }

    }

 /*   fun onClickedLogin(emailUser: String) {
        viewModelScope.launch(Dispatchers.IO){
            createUserUseCase.invoke(User(emailUser))
            //    text.value = "Changed Text"
            delay(1000)
            val user = getUserUseCase.invoke("test")
        }

    }*/

}