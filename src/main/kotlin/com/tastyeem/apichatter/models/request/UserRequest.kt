package com.tastyeem.apichatter.models.request

data class UserRequest(
    val nickname: String,
    val password: String,
    val email: String?
)