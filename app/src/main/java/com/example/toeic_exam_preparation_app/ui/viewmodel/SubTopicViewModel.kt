package com.example.toeic_exam_preparation_app.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.toeic_exam_preparation_app.data.remote.SubTopic
import com.example.toeic_exam_preparation_app.data.repository.SubTopicRepository

class SubTopicViewModel : ViewModel() {
    private var repository = SubTopicRepository()

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _subTopics = MutableLiveData<Result<List<SubTopic>>>()
    val subTopics: LiveData<Result<List<SubTopic>>> = _subTopics

    fun loadData(id: Int) {
        if (_subTopics.value?.getOrNull().isNullOrEmpty()) {
            _loading.value = true
            repository.findAllByTopic(id).observeForever { result ->
                _subTopics.value = result
                _loading.value = false
            }
        }
    }
}