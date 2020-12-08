package com.tastyeem.apichatter.models

data class UserRequest(
    val login: String,
    val password: String,
    val email: String?
)