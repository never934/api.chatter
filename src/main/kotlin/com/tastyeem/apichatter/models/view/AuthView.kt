package com.tastyeem.apichatter.models.view

data class AuthView(
    val userId: String,
    val token: String
) : BaseView