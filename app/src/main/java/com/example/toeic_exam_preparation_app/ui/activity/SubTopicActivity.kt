package com.example.toeic_exam_preparation_app.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.toeic_exam_preparation_app.R
import com.example.toeic_exam_preparation_app.ui.adapter.SubTopicAdapter
import com.example.toeic_exam_preparation_app.ui.viewmodel.SubTopicViewModel

class SubTopicActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SubTopicAdapter
    private lateinit var btnClose: ImageView
    private lateinit var viewModel: SubTopicViewModel
    private lateinit var progressBar: ProgressBar

    private lateinit var name: TextView
    private lateinit var totalWord: TextView
    private lateinit var totalLesson: TextView
    private var topicId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)
        setContentView(R.layout.activity_sub_topic)

        applyInsets()
        initViewModel()
        setupViews()
        setupListeners()
        setupRecyclerView()
        observeViewModel()
        loadData()
    }

    private fun applyInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[SubTopicViewModel::class.java]
    }

    private fun setupViews() {
        topicId = intent.getIntExtra("vocabularyTopicId", -1)

        name = findViewById(R.id.name)
        totalWord = findViewById(R.id.totalWord)
        totalLesson = findViewById(R.id.totalLesson)
        btnClose = findViewById(R.id.btn_close_topic)
        progressBar = findViewById(R.id.progressBar)
        recyclerView = findViewById(R.id.listSubTopic)

        name.text = intent.getStringExtra("nameTopic") ?: ""
        totalWord.text = intent.getIntExtra("totalWord", 0).toString()
        totalLesson.text = intent.getIntExtra("totalLesson", 0).toString()
    }

    private fun setupListeners() {
        btnClose.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun setupRecyclerView() {
        adapter = SubTopicAdapter(emptyList())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun observeViewModel() {
        viewModel.loading.observe(this) { isLoading ->
            progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }

        viewModel.subTopics.observe(this) { result ->
            result.onSuccess { list ->
                adapter.updateData(list)
                recyclerView.visibility = View.VISIBLE
            }.onFailure {
                recyclerView.visibility = View.GONE
            }
        }
    }

    private fun loadData() {
        viewModel.loadData(topicId)
    }
}
