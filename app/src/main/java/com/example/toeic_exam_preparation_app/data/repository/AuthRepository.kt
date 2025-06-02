package com.example.toeic_exam_preparation_app.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.toeic_exam_preparation_app.data.api.RetrofitClient
import com.example.toeic_exam_preparation_app.data.remote.LoginRequest
import com.example.toeic_exam_preparation_app.data.remote.LoginResponse
import com.example.toeic_exam_preparation_app.util.AuthManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthRepository(private val context: Context) {
    fun login(request: LoginRequest): LiveData<Result<LoginResponse>> {
        val result = MutableLiveData<Result<LoginResponse>>()

        RetrofitClient.apiService.login(request).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    val loginResponse = response.body()!!
                    val authManager = AuthManager(context)
                    authManager.saveToken(loginResponse.user.token)
                    result.value = Result.success(loginResponse)
                } else {
                    result.value = Result.failure(Exception("Lỗi: ${response.code()}"))
                }
            }
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                result.value = Result.failure(t)
            }
        })
        return result
    }
}