package com.example.searchgourmet.data.remote


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Budget(
    val average: String?,
    val code: String?,
    val name: String?
)