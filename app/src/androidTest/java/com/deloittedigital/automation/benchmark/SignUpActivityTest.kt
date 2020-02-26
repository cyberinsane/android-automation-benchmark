package com.deloittedigital.automation.benchmark

import androidx.test.espresso.Espresso
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.deloittedigital.automation.benchmark.ui.signup.SignUpActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class SignUpActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(SignUpActivity::class.java)

    private val foundationActivityRobot: FoundationActivityRobot = FoundationActivityRobot()
    private val signUpDialog: SignUpDialog = SignUpDialog()
    private val basicNavigation: BasicNavigation = BasicNavigation()

    @Test
    fun createAccountHappyPath() {
        ThreadUtils.performWaitShort()
        basicNavigation.tapSignUpButton()
        signUpDialog.enterFirstName("Ashita")
        signUpDialog.enterLastName("Asati")
        signUpDialog.enterEmailAddress("test1@mailinator.com")
        signUpDialog.enterPassword("Password1@3")
        signUpDialog.enterMobileNumber("9823523456")
        Espresso.closeSoftKeyboard()
        ThreadUtils.performWaitShort()
        signUpDialog.pressCreateAccountButton()
    }

    @Test
    fun seesLoginButton() {
        foundationActivityRobot
            .seesTextInTextView(
                R.id.btnLoginNavigate, R.string.action_sign_in_short
            )
    }

    @Test
    fun seesSignUpHeaderText() {
        foundationActivityRobot
            .seesTextInTextView(
                R.id.txtViewSignUpHeader, R.string.create_account_header
            )
    }

    @Test
    fun seesCreateAccountButton() {
        foundationActivityRobot
            .seesTextInTextView(
                R.id.btnCreateAccount, R.string.create_account
            )
    }

    @Test
    fun seesLastNameHintText() {
        foundationActivityRobot
            .seesHintTextInTextView(
                R.id.editTextLastName, R.string.create_account_form_hint_last_name
            )
    }

    @Test
    fun seesEmailAddressHintText() {
        foundationActivityRobot
            .seesHintTextInTextView(
                R.id.editTextSignUpEmailAddress, R.string.create_account_form_hint_email_address
            )
    }

    @Test
    fun seesMobileNoHintTextText() {
        foundationActivityRobot
            .seesHintTextInTextView(
                R.id.editTextMobileNo, R.string.create_account_form_hint_phone_no
            )
    }

    @Test
    fun seesFirstNameHintText() {
        foundationActivityRobot
            .seesHintTextInTextView(
                R.id.editTextFirstName, R.string.create_account_form_hint_first_name
            )
    }
}
