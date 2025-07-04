package com.example.toeic_exam_preparation_app.ui.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.toeic_exam_preparation_app.data.remote.LoginRequest
import com.example.toeic_exam_preparation_app.data.remote.LoginResponse
import com.example.toeic_exam_preparation_app.data.repository.AuthRepository

class AuthViewModel : ViewModel() {
    private var repository: AuthRepository? = null

    private val _loginResult = MutableLiveData<Result<LoginResponse>>()
    val loginResult: LiveData<Result<LoginResponse>> = _loginResult

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    fun login(context: Context, username: String, password: String) {
        repository = AuthRepository(context)
        _loading.value = true
        val request = LoginRequest(username, password)
        repository?.login(request)?.observeForever {
            _loginResult.value = it
            _loading.value = false
        }
    }
}