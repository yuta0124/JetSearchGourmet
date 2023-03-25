package com.example.searchgourmet.utils

sealed class NetWorkResponse<T>(
    val data: T? = null,
    val error: String? = null
) {
    class Success<T>(data: T): NetWorkResponse<T>(data = data)
    class Failure<T>(error: String): NetWorkResponse<T>(error = error)
    class Loading<T>: NetWorkResponse<T>()
}