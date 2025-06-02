package com.example.toeic_exam_preparation_app.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.toeic_exam_preparation_app.data.api.RetrofitClient
import com.example.toeic_exam_preparation_app.data.remote.Vocabulary
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VocabularyRepository {
    fun findAllBySubTopic(id: Int) : LiveData<Result<List<Vocabulary>>> {
        val result = MutableLiveData<Result<List<Vocabulary>>>()
        RetrofitClient.apiService.findAllVocabularyBySubTopic(id).enqueue(object : Callback<List<Vocabulary>> {
            override fun onResponse(
                call: Call<List<Vocabulary>>,
                response: Response<List<Vocabulary>>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    result.value = Result.success(response.body()!!)
                } else {
                    result.value = Result.failure(Exception("Lỗi: ${response.code()}"))
                }
            }
            override fun onFailure(call: Call<List<Vocabulary>>, t: Throwable) {
                result.value = Result.failure(t)
            }
        })
        return result
    }
}