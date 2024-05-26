/*
 * Mya Than Htet
 * Copyright (c) 2024.
 */

package com.mya.bookdbcodetest.ui.register


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.mya.bookdbcodetest.MainActivity
import com.mya.bookdbcodetest.databinding.ActivityRegisterBinding
import com.mya.bookdbcodetest.ui.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private val viewModel: RegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerBtn.setOnClickListener {
            val username = binding.registerUsernameEdt.text.toString()
            val password = binding.registerPasswordEdt.text.toString()
            viewModel.registerUser(username, password)
        }

        binding.alreadyRegisterTv.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        viewModel.registrationStatus.observe(this) { isSuccess ->
            if (isSuccess) {
                Toast.makeText(this, "Register Successful", Toast.LENGTH_SHORT).show()

                // Registration successful, navigate to next screen
                startActivity(Intent(this, MainActivity::class.java))
                finish()

            } else {

                // Display error message to the user
            }
        }
    }
}
