package com.example.toeic_exam_preparation_app.ui.fragment.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.toeic_exam_preparation_app.R
import com.example.toeic_exam_preparation_app.ui.activity.HomeActivity
import com.example.toeic_exam_preparation_app.ui.viewmodel.AuthViewModel

class LoginFragment : Fragment() {
    private lateinit var textRegister : TextView

    private lateinit var authViewModel: AuthViewModel
    private lateinit var edtUsername: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button

    private lateinit var errorUsername: TextView
    private lateinit var errorPassword: TextView

    private lateinit var progressBar: ProgressBar
    private lateinit var loadingOverlay : FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        textRegister = view.findViewById(R.id.t_register)

        edtUsername = view.findViewById(R.id.et_email)
        edtPassword = view.findViewById(R.id.et_password)

        errorUsername = view.findViewById(R.id.errorUsername)
        errorPassword = view.findViewById(R.id.errorPassword)

        btnLogin = view.findViewById(R.id.btn_login)

        progressBar = view.findViewById(R.id.progressBar)
        loadingOverlay = view.findViewById(R.id.loadingOverlay)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        authViewModel = ViewModelProvider(this)[AuthViewModel::class.java]
        textRegister.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.mainLayout,RegisterFragment())
                .commit()
        }

        btnLogin.setOnClickListener {

            var isValid = true

            if (edtUsername.text.isNullOrBlank()) {
                errorUsername.text = getString(R.string.errorUsername)
                errorUsername.visibility = View.VISIBLE
                isValid = false
            } else {
                errorUsername.visibility = View.GONE
            }

            if (edtPassword.text.isNullOrBlank()) {
                errorPassword.text = getString(R.string.errorPassword)
                errorPassword.visibility = View.VISIBLE
                isValid = false
            } else {
                errorPassword.visibility = View.GONE
            }

            if (isValid) {
                val username = edtUsername.text.toString()
                val password = edtPassword.text.toString()
                authViewModel.login(requireContext(), username, password)
            }
        }

        authViewModel.loading.observe(viewLifecycleOwner) { isLoading ->
            progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
            loadingOverlay.visibility = if (isLoading) View.VISIBLE else View.GONE
            btnLogin.isEnabled = !isLoading
        }

        authViewModel.loginResult.observe(viewLifecycleOwner, { result ->
            result.onSuccess {
                val intent = Intent(context, HomeActivity::class.java)
                startActivity(intent)
                requireActivity().finish()
            }.onFailure { exception ->
                Toast.makeText(context, "Login failed: ${exception.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}