package com.example.toeic_exam_preparation_app.data.remote

data class Vocabulary(
    val vocabularyId : Int,
    val pronunciation : String,
    val vi : String,
    val en : String,
    val imageUrl : String,
)