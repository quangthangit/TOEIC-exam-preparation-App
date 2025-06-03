package com.example.toeic_exam_preparation_app.data.api

import com.example.toeic_exam_preparation_app.data.remote.LoginRequest
import com.example.toeic_exam_preparation_app.data.remote.LoginResponse
import com.example.toeic_exam_preparation_app.data.remote.SubTopic
import com.example.toeic_exam_preparation_app.data.remote.Topic
import com.example.toeic_exam_preparation_app.data.remote.Vocabulary
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @POST("login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @GET("user/topic/findAll")
    fun findAllTopic(): Call<List<Topic>>

    @GET("admin/sub-topic/findAllByTopic/{id}")
    fun findAllSubTopicByTopic(@Path("id") id: Int): Call<List<SubTopic>>

    @GET("user/vocabulary/findAllBySubTopic/{id}")
    fun findAllVocabularyBySubTopic(@Path("id") id: Int): Call<List<Vocabulary>>
}