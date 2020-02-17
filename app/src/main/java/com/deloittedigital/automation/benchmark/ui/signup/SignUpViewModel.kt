package com.deloittedigital.automation.benchmark.ui.signup

import android.util.Patterns
import androidx.lifecycle.ViewModel
import com.deloittedigital.automation.benchmark.ValidationState
import com.deloittedigital.automation.benchmark.ValidationState.*
import com.deloittedigital.automation.benchmark.ui.ShareDataHolder

class SignUpViewModel : ViewModel() {

    var firstName: String? = null
    var userPassword: String? = null
    var lastName: String? = null
    var phoneNumber: String? = null
    var emailID: String? = null


    private fun isUserNameValid(): ValidationState {
        return if (firstName.toString().isEmpty()) {
            EMPTY
        } else {
            VALID
        }
    }

    private fun isPasswordValid(): ValidationState {
        return if (userPassword.toString().isEmpty()) {
            EMPTY
        } else {
            VALID
        }

    }

    private fun isValidEmailId(): ValidationState {
        return if (emailID.toString().isEmpty()) {
            EMPTY
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailID.toString()).matches()) {
            INVALID
        } else {
            VALID
        }
    }

    fun isValidData(): Boolean {
        if (isUserNameValid() == VALID && isPasswordValid() == VALID && isValidEmailId() == VALID) {
            ShareDataHolder.putUserData(
                firstName,
                lastName,
                userPassword,
                emailID,
                phoneNumber
            )
            return true
        }
        return false
    }

}