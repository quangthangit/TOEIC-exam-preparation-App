package com.example.toeic_exam_preparation_app.data.api

import com.example.toeic_exam_preparation_app.data.remote.LoginRequest
import com.example.toeic_exam_preparation_app.data.remote.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>
}