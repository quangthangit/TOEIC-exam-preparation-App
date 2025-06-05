package com.example.toeic_exam_preparation_app.ui.activity

import ExamDescAdapter
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.toeic_exam_preparation_app.R
import com.example.toeic_exam_preparation_app.data.remote.Part
import com.example.toeic_exam_preparation_app.data.remote.Tag
import com.example.toeic_exam_preparation_app.util.PartDataSource

class ExamDescActivity : AppCompatActivity() {
    private lateinit var rvParts: RecyclerView
    private lateinit var adapter: ExamDescAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_exam_desc)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val fakeParts = PartDataSource.fakeParts
        rvParts = findViewById(R.id.listPart)
        adapter = ExamDescAdapter(fakeParts)
        rvParts.layoutManager = LinearLayoutManager(this)
        rvParts.adapter = adapter
        val languages = resources.getStringArray(R.array.select_time)
        val arrayAdapter = ArrayAdapter(this, R.layout.item_dropdown, languages)
        val autocompleteTV = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        autocompleteTV.setAdapter(arrayAdapter)
    }
}