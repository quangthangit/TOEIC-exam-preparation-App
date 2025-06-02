package com.example.toeic_exam_preparation_app.data.remote

data class User(
    val username: String,
    val role: String,
    val isActive: Boolean,
    val token: String,
)