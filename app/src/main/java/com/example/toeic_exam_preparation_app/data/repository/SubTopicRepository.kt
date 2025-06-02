package com.example.toeic_exam_preparation_app.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.toeic_exam_preparation_app.data.api.RetrofitClient
import com.example.toeic_exam_preparation_app.data.remote.SubTopic
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SubTopicRepository {
    fun findAllByTopic(id: Int) : LiveData<Result<List<SubTopic>>> {
        val result = MutableLiveData<Result<List<SubTopic>>>()
        RetrofitClient.apiService.findAllSubTopicByTopic(id).enqueue(object : Callback<List<SubTopic>> {
            override fun onResponse(
                call: Call<List<SubTopic>>,
                response: Response<List<SubTopic>>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    result.value = Result.success(response.body()!!)
                } else {
                    result.value = Result.failure(Exception("Lỗi: ${response.code()}"))
                }
            }

            override fun onFailure(call: Call<List<SubTopic>>, t: Throwable) {
                result.value = Result.failure(t)
            }
        })
        return result
    }
}