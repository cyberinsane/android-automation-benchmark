package com.deloittedigital.automation.benchmark.ui.signup

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.deloittedigital.automation.benchmark.R
import com.deloittedigital.automation.benchmark.ui.MainActivity
import com.deloittedigital.automation.benchmark.ui.ShareDataHolder
import com.deloittedigital.automation.benchmark.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity(R.layout.activity_sign_up) {

    private var viewModel: SignUpViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)

        setOnClickListener()
    }

    private fun setOnClickListener() {
        btnLoginNavigate.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        btnCreateAccount.setOnClickListener {
            viewModel?.apply {
                firstName = editTextFirstName.text.toString()
                lastName = editTextLastName.text.toString()
                emailID = editTextSignUpEmailAddress.text.toString()
                userPassword = editTextSignUpPassword.text.toString()
                phoneNumber = editTextMobileNo.text.toString()
            }

            if (viewModel!!.isValidData()) {
                ShareDataHolder.keepUser(
                    editTextSignUpEmailAddress.text.toString()
                )
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                showError()
            }
        }
    }

    private fun showError() {
        //no-op
    }
}
