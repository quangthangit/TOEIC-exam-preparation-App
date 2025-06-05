package com.example.toeic_exam_preparation_app.ui.fragment.examdesc

import ExamDescAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.toeic_exam_preparation_app.R
import com.example.toeic_exam_preparation_app.util.PartDataSource

class PracticeFragment : Fragment() {

    private lateinit var rvParts: RecyclerView
    private lateinit var adapter: ExamDescAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_practice, container, false)
        val fakeParts = PartDataSource.fakeParts
        rvParts = view.findViewById(R.id.listPart)
        adapter = ExamDescAdapter(fakeParts)
        rvParts.layoutManager = LinearLayoutManager(requireContext())
        rvParts.adapter = adapter
        val languages = resources.getStringArray(R.array.select_time)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.item_dropdown, languages)
        val autocompleteTV = view.findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        autocompleteTV.setAdapter(arrayAdapter)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}