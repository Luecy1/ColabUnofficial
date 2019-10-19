package com.github.luecy1.colabunofficial.model

sealed class Response

data class Success<T>(
    val value: T
) : Response()

data class Failure(
    val message: String
) : Response()
