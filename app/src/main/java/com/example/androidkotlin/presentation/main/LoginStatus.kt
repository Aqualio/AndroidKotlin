package com.example.androidkotlin.presentation.main

sealed class LoginStatus

data class LoginSuccess(val email: String) : LoginStatus() // ADD PASSWORD IN CONSTRUCTOR

object LoginError : LoginStatus()