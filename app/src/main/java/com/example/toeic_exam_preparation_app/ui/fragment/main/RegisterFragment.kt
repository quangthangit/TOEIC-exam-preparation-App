package com.example.toeic_exam_preparation_app.ui.fragment.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.toeic_exam_preparation_app.R

class RegisterFragment : Fragment() {

    private lateinit var btnContinue : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)
        btnContinue = view.findViewById(R.id.btn_continue)
        btnContinue.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.mainLayout,OTPFragment())
                .commit()
        }
        return view
    }
}