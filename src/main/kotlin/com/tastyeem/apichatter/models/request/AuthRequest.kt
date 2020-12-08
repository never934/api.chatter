package com.tastyeem.apichatter.models.request

data class AuthRequest(
    val login: String,
    val password: String
)