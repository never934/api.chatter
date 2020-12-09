package com.tastyeem.apichatter.models.db

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class User(
    @Id
    val id: UUID,
    val nickname: String,
    val passwordHash: String,
    val email: String?,
    val createdDate: Long,
    val updatedDate: Long
)