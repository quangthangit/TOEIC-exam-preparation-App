package com.example.toeic_exam_preparation_app.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.toeic_exam_preparation_app.R
import com.example.toeic_exam_preparation_app.ui.fragment.examdesc.ExamFragment
import com.example.toeic_exam_preparation_app.ui.fragment.examdesc.PracticeFragment

class ExamDescActivity : AppCompatActivity() {

    private lateinit var textPractice : TextView
    private lateinit var textFullTest : TextView

    private lateinit var viewPractice : View
    private lateinit var viewFullTest : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_exam_desc)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textPractice = findViewById(R.id.tabPractice)
        textFullTest = findViewById(R.id.tabFullTest)

        viewPractice = findViewById(R.id.underlinePractice)
        viewFullTest = findViewById(R.id.underlineDiscussion)

        textPractice.setOnClickListener {
            replaceFragment(PracticeFragment())
            textPractice.setTextColor(getResources().getColor(R.color.colorPrimary))
            viewPractice.setBackgroundColor(getResources().getColor(R.color.colorPrimary))

            textFullTest.setTextColor(Color.GRAY)
            viewFullTest.setBackgroundColor(Color.TRANSPARENT)
        }

        textFullTest.setOnClickListener {
            replaceFragment(ExamFragment())
            textFullTest.setTextColor(getResources().getColor(R.color.colorPrimary))
            viewFullTest.setBackgroundColor(getResources().getColor(R.color.colorPrimary))

            textPractice.setTextColor(Color.GRAY)
            viewPractice.setBackgroundColor(Color.TRANSPARENT)
        }

        replaceFragment(PracticeFragment())
    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.examDescLayout, fragment)
        fragmentTransaction.commit()
    }
}