package com.tastyeem.apichatter.models.request

data class UserRequest(
    val login: String,
    val password: String,
    val email: String?
)