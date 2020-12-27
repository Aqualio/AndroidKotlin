package com.example.androidkotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {

    val text: MutableLiveData<String> = MutableLiveData()

    init {
        text.value = "Texte LiveData"
    }


    fun onClickedChange() {
        text.value = "Changed Text"
    }


}