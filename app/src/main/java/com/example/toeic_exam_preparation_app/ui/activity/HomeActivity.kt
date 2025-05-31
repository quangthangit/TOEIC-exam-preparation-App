package com.example.toeic_exam_preparation_app.ui.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.toeic_exam_preparation_app.R
import com.example.toeic_exam_preparation_app.ui.fragment.home.AccountFragment
import com.example.toeic_exam_preparation_app.ui.fragment.home.HomeFragment
import com.example.toeic_exam_preparation_app.ui.fragment.home.ProgressFragment
import com.example.toeic_exam_preparation_app.ui.fragment.home.VocabularyFragment


class HomeActivity : AppCompatActivity() {

    private lateinit var homeIcon : ImageView
    private lateinit var vocabularyIcon : ImageView
    private lateinit var proggressIcon : ImageView
    private lateinit var accountIcon : ImageView

    private lateinit var homeText : TextView
    private lateinit var vocabularyText : TextView
    private lateinit var proggressText : TextView
    private lateinit var accountText : TextView

    private lateinit var homeOption : LinearLayout
    private lateinit var vocabularyOption : LinearLayout
    private lateinit var proggressOption : LinearLayout
    private lateinit var accountOption : LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        replaceFragment(HomeFragment())

        homeIcon = findViewById<ImageView>(R.id.homeIcon)
        vocabularyIcon = findViewById<ImageView>(R.id.vocabularyIcon)
        proggressIcon = findViewById<ImageView>(R.id.proggressIcon)
        accountIcon = findViewById<ImageView>(R.id.accountIcon)

        homeText = findViewById<TextView>(R.id.homeT)
        vocabularyText = findViewById<TextView>(R.id.vocabularyT)
        proggressText = findViewById<TextView>(R.id.proggressT)
        accountText = findViewById<TextView>(R.id.accountT)

        homeOption = findViewById<LinearLayout>(R.id.homeOption)
        vocabularyOption = findViewById<LinearLayout>(R.id.vocabularyOption)
        proggressOption = findViewById<LinearLayout>(R.id.proggressOption)
        accountOption = findViewById<LinearLayout>(R.id.accountOption)

        homeText.setTextColor(getResources().getColor(R.color.colorPrimary))
        homeIcon.setColorFilter(getResources().getColor(R.color.colorPrimary))

        homeOption.setOnClickListener {
            replaceFragment(HomeFragment())
            resetIcons()
            homeText.setTextColor(getResources().getColor(R.color.colorPrimary))
            homeIcon.setColorFilter(getResources().getColor(R.color.colorPrimary))
        }

        vocabularyOption.setOnClickListener {
            replaceFragment(VocabularyFragment())
            resetIcons()
            vocabularyIcon.setColorFilter(getResources().getColor(R.color.colorPrimary))
            vocabularyText.setTextColor(getResources().getColor(R.color.colorPrimary))
        }

        proggressOption.setOnClickListener {
            replaceFragment(ProgressFragment())
            resetIcons()
            proggressIcon.setColorFilter(getResources().getColor(R.color.colorPrimary))
            proggressText.setTextColor(getResources().getColor(R.color.colorPrimary))
        }

        accountOption.setOnClickListener {
            replaceFragment(AccountFragment())
            resetIcons()
            accountIcon.setColorFilter(getResources().getColor(R.color.colorPrimary))
            accountText.setTextColor(getResources().getColor(R.color.colorPrimary))
        }

//        bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
//        bottomNavigationView.setOnItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.home -> replaceFragment(HomeFragment())
//                R.id.vocabulary -> replaceFragment(VocabularyFragment())
//                R.id.account -> replaceFragment(AccountFragment())
//            }
//            true
//        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.homeLayout, fragment)
        fragmentTransaction.commit()
    }

    private fun resetIcons() {
        homeIcon.setColorFilter("#82898F".toColorInt());
        vocabularyIcon.setColorFilter("#82898F".toColorInt());
        proggressIcon.setColorFilter("#82898F".toColorInt());
        accountIcon.setColorFilter("#82898F".toColorInt());
        accountText.setTextColor("#82898F".toColorInt())
        proggressText.setTextColor("#82898F".toColorInt())
        homeText.setTextColor("#82898F".toColorInt())
        vocabularyText.setTextColor("#82898F".toColorInt())
    }
}