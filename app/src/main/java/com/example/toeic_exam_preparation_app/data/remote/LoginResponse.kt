package com.example.toeic_exam_preparation_app.data.remote

data class LoginResponse(
    val message: String,
    val user: User,
    val token : String,
)