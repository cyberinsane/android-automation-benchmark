package com.deloittedigital.automation.benchmark.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.deloittedigital.automation.benchmark.R
import com.deloittedigital.automation.benchmark.ValidationState
import com.deloittedigital.automation.benchmark.ValidationState.INVALID
import com.deloittedigital.automation.benchmark.ValidationState.VALID
import com.deloittedigital.automation.benchmark.ui.MainActivity
import com.deloittedigital.automation.benchmark.ui.ShareDataHolder
import com.deloittedigital.automation.benchmark.ui.signup.SignUpActivity
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity(R.layout.activity_login) {

    private var viewModel: LoginViewModel? = null

    companion object {
        fun createIntent(context: Context): Intent =
            Intent(context, LoginActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get<LoginViewModel>(
            LoginViewModel::class.java)

        if (ShareDataHolder.getLoggedInUser().isNotEmpty()) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        setOnClickListener()
    }

    private fun setOnClickListener() {
        login.setOnClickListener {
            if (isUserNameValid() && isPasswordValid()) {
                ShareDataHolder.keepUser(
                    emailId = username.text.toString()
                )
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }

        signUp.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }

    private fun isUserNameValid(): Boolean {
        return when (viewModel?.verifyUserName(username.text.toString())) {
            INVALID -> {
                username.error = getString(R.string.email_address_invalid)
                false
            }
            ValidationState.EMPTY -> {
                username.error = getString(R.string.email_address_empty)
                false
            }
            VALID -> {
                true
            }
            else -> false
        }
    }

    private fun isPasswordValid(): Boolean {
        return when (viewModel?.verifyPassword(password.text.toString())) {
            INVALID -> {
                password.error = getString(R.string.password_invalid)
                false
            }
            VALID -> {
                true
            }
            ValidationState.EMPTY -> {
                password.error = getString(R.string.password_empty)
                false
            }
            else -> false
        }
    }
}