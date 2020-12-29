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


    val loginLiveData: MutableLiveData<LoginStatus> = MutableLiveData()


    fun onClickedLogin(emailUser: String, password: String) {
        viewModelScope.launch(Dispatchers.IO){

            val user = getUserUseCase.invoke(emailUser, password)
          //  val user = getUserUseCase.invoke("test")
            val loginStatus = if(user != null){
                LoginSuccess(user.email, user.password)
            }else{
                LoginError
            }

            withContext(Dispatchers.Main) {
                loginLiveData.value = loginStatus
            }
        }

    }

    fun onClickedCreateAccount(emailUser: String, password: String) {
        viewModelScope.launch(Dispatchers.IO){
            //val user = createUserUseCase.invoke(User(emailUser, password)) //SHOULD ADD IF ALREADY EXIST
            val user = getUserUseCase.invoke(emailUser, password)

            val loginStatus = if(user == null){
                createUserUseCase.invoke(User(emailUser, password))
                AccountSuccess(emailUser, password)

            }else{
                AccountError
            }

            withContext(Dispatchers.Main) {
                loginLiveData.value = loginStatus
            }
        }

    }

}