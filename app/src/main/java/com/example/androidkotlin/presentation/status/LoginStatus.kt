package com.example.androidkotlin.presentation.status

sealed class LoginStatus

data class LoginSuccess(val email: String, val password: String) : LoginStatus()

object LoginError : LoginStatus()

data class AccountSuccess(val email: String, val password: String) : LoginStatus()

object AccountError : LoginStatus()