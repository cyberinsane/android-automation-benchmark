package com.deloittedigital.automation.benchmark.ui.login

import androidx.lifecycle.ViewModel
import com.deloittedigital.automation.benchmark.ValidationState
import com.deloittedigital.automation.benchmark.ValidationState.*
import com.deloittedigital.automation.benchmark.ui.ShareDataHolder

class LoginViewModel : ViewModel() {

    fun verifyUserName(username: String): ValidationState {
        return if (username.isEmpty()) {
            EMPTY

        } else {
            if (ShareDataHolder.validateUser(username))
                VALID
            else
                INVALID
        }
    }

    fun verifyPassword(password: String): ValidationState {
        return if (password.isEmpty()) {
            EMPTY
        } else {
            if (ShareDataHolder.validatePassword(password))
                VALID
            else
                INVALID
        }
    }

}