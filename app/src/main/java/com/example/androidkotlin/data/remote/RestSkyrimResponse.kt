package com.example.androidkotlin.data.remote

import com.example.androidkotlin.domain.entity.Skyrimraces

data class RestSkyrimResponse(
    val liste: List<Skyrimraces>
)