package com.dev.userservice.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "tbl_users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id:Long = -1,
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    val createdAt: Date) {

}