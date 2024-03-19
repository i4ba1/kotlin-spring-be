package com.dev.userservice.dto

import com.dev.userservice.model.User
import java.util.*


data class UserCreateRequest(
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String
)

fun UserCreateRequest.toEntity() = User(
    firstName = firstName,
    lastName = lastName,
    email = email,
    password = password,
    createdAt = Date()
)

data class UserUpdateRequest(
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
)

fun UserUpdateRequest.toEntity(id: Long) = User(
    id =id,
    firstName = firstName,
    lastName = lastName,
    email = email,
    password = password,
    createdAt = Date()
)