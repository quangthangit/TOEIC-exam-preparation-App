package com.example.toeic_exam_preparation_app.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.toeic_exam_preparation_app.data.api.RetrofitClient
import com.example.toeic_exam_preparation_app.data.remote.Topic
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopicRepository() {
    fun findAllTopic(): LiveData<Result<List<Topic>>> {
        val result = MutableLiveData<Result<List<Topic>>>()
        RetrofitClient.apiService.findAllTopic().enqueue(object : Callback<List<Topic>> {
            override fun onResponse(
                call: Call<List<Topic>>,
                response: Response<List<Topic>>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    result.value = Result.success(response.body()!!)
                } else {
                    result.value = Result.failure(Exception("Lỗi: ${response.code()}"))
                }
            }

            override fun onFailure(call: Call<List<Topic>>, t: Throwable) {
                result.value = Result.failure(t)
            }
        })

        return result
    }
}