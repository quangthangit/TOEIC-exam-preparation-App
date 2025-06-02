package com.example.toeic_exam_preparation_app.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.toeic_exam_preparation_app.data.remote.Topic
import com.example.toeic_exam_preparation_app.data.repository.TopicRepository

class TopicViewModel : ViewModel() {
    private var repository = TopicRepository()

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _topics = MutableLiveData<Result<List<Topic>>>()
    val topics: LiveData<Result<List<Topic>>> = _topics

    fun loadTopicsIfNeeded() {
        if (_topics.value?.getOrNull().isNullOrEmpty()) {
            _loading.value = true
            repository.findAllTopic().observeForever { result ->
                _topics.value = result
                _loading.value = false
            }
        }
    }
}