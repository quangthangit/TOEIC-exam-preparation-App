package com.example.toeic_exam_preparation_app.data.remote

data class Part(
    val partId : Int,
    val name : String,
    val questionNumber : Int,
    val tags : List<Tag>
)