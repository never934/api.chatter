package com.tastyeem.apichatter.models.db

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class User(
    @Id
    val id: String,
    val nickname: String,
    val passwordHash: String,
    val avatarUrl: String? = null,
    val email: String? = null,
    val createdDate: Long,
    val updatedDate: Long
)