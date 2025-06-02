package com.example.toeic_exam_preparation_app.data.remote

data class Topic (
    val vocabularyTopicId : Int,
    val name : String,
    val des : String,
    val images : String,
    val totalWord : Int,
    val totalLesson : Int
)