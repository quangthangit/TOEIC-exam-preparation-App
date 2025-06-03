package com.example.toeic_exam_preparation_app.ui.activity

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.toeic_exam_preparation_app.R
import com.example.toeic_exam_preparation_app.data.remote.Vocabulary
import com.example.toeic_exam_preparation_app.ui.viewmodel.VocabularyViewModel
import java.util.*

class OverViewVocabularyActivity : AppCompatActivity() {

    private lateinit var btnClose: ImageView
    private lateinit var image: ImageView
    private lateinit var en: TextView
    private lateinit var vi: TextView
    private lateinit var number: TextView
    private lateinit var pronunciation: TextView
    private lateinit var example: TextView
    private lateinit var btnNext: Button
    private lateinit var btnLast: Button
    private lateinit var btnSpeak: ImageButton
    private lateinit var vocabularyLayout: LinearLayout

    private lateinit var tts: TextToSpeech
    private lateinit var viewModel: VocabularyViewModel
    private var vocabularyList: List<Vocabulary> = emptyList()
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_over_view_vocabulary)

        initViews()
        initTTS()
        initViewModel()
        initEvents()
    }

    private fun initViews() {
        btnClose = findViewById(R.id.btn_close_overview)
        image = findViewById(R.id.image)
        en = findViewById(R.id.en)
        vi = findViewById(R.id.vi)
        number = findViewById(R.id.number)
        pronunciation = findViewById(R.id.pronunciation)
        example = findViewById(R.id.example)
        btnNext = findViewById(R.id.btn_next)
        btnLast = findViewById(R.id.btn_last)
        btnSpeak = findViewById(R.id.btn_speak)
        vocabularyLayout = findViewById(R.id.vocabularyLayout)
    }

    private fun initTTS() {
        tts = TextToSpeech(this) { status ->
            if (status == TextToSpeech.SUCCESS) {
                tts.language = Locale.US
            }
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[VocabularyViewModel::class.java]
        viewModel.vocabulary.observe(this) { result ->
            result.onSuccess { list ->
                if (list.isNotEmpty()) {
                    vocabularyList = list
                    displayVocabulary(currentIndex)
                }
            }
        }
        viewModel.loadData(1)
    }

    private fun initEvents() {
        btnClose.setOnClickListener { finish() }

        btnNext.setOnClickListener {
            if (currentIndex < vocabularyList.lastIndex) {
                currentIndex++
                displayVocabulary(currentIndex)
            }
        }

        btnLast.setOnClickListener {
            if (currentIndex > 0) {
                currentIndex--
                displayVocabulary(currentIndex)
            }
        }

        btnSpeak.setOnClickListener {
            val text = vocabularyList.getOrNull(currentIndex)?.en
            if (!text.isNullOrEmpty()) {
                tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
            }
        }
    }

    private fun displayVocabulary(index: Int) {
        val vocab = vocabularyList[index]
        en.text = vocab.en
        vi.text = vocab.vi
        number.text = "Question ${index + 1}"
        image.load(vocab.imageUrl)
        pronunciation.text = vocab.pronunciation
    }

    override fun onDestroy() {
        if (::tts.isInitialized) {
            tts.stop()
            tts.shutdown()
        }
        super.onDestroy()
    }
}
