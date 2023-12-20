package com.example.cvapplication

data class Profile(
    val foto: Int,
    val name: String,
    val number: String,
    val email: String,
    val info: String = "",
)
