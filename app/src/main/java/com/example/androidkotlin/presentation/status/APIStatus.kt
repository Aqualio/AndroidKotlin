package com.example.androidkotlin.presentation.status

import com.example.androidkotlin.domain.entity.Skyrimraces

sealed class APIStatus

data class APISuccess(val charaList: List<Skyrimraces>) : APIStatus()

object APIError : APIStatus()