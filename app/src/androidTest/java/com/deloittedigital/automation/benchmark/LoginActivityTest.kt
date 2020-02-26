package com.deloittedigital.automation.benchmark

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.hasErrorText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.deloittedigital.automation.benchmark.ui.login.LoginActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class LoginActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(LoginActivity::class.java)

    private val foundationActivityRobot: FoundationActivityRobot = FoundationActivityRobot()
    private val loginDialog: LoginDialog = LoginDialog()
    private val basicNavigation: BasicNavigation = BasicNavigation()
    private val homeScreen: MenuContainer = MenuContainer()

    @Test
    fun launchLoginFragment() {
        ThreadUtils.performWaitShort()
        basicNavigation.tapLoginButton()
        Espresso.closeSoftKeyboard()
        loginDialog.emailAddress()
            .check(matches(ViewMatchers.isDisplayed()))
        loginDialog.password().check(matches(ViewMatchers.isDisplayed()))
            .check(matches(ViewMatchers.isDisplayed()))
        loginDialog.loginButton().check(matches(ViewMatchers.isDisplayed()))
        loginDialog.signUpFromLoginButton()
            .check(matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun loginHappyPath() {
        ThreadUtils.performWaitShort()
        basicNavigation.tapLoginButton()
        loginDialog.enterEmailAddress("test1@mailinator.com")
        loginDialog.enterPassword("Password1@3")
        Espresso.closeSoftKeyboard()
        ThreadUtils.performWaitShort()
        loginDialog.pressLoginButton()
    }

    @Test
    fun loginWithMissingCredentialsDisplaysError() {
        val emailErrorMessage = "Email address is required"
        basicNavigation.tapLoginButton()
        Espresso.closeSoftKeyboard()
        loginDialog.pressLoginButton()
        loginDialog.emailAddress().check(matches(hasErrorText(emailErrorMessage)))
    }

    @Test
    fun verifyPasswordVisibilityToggle() {
        val tempPassword = "Password!23"
        basicNavigation.tapLoginButton()
        Espresso.closeSoftKeyboard()
        loginDialog.enterPassword(tempPassword)
        Espresso.closeSoftKeyboard()
        loginDialog.password()
            .check(matches(ViewMatchers.withText(tempPassword)))
    }

    @Test
    fun cancelLoginFlow() {
        basicNavigation.tapLoginButton()
        homeScreen.loginButton().check(matches(ViewMatchers.isDisplayed()))
        homeScreen.signUpButton().check(matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun seesUserNameText() {
        foundationActivityRobot
            .seesHintTextInTextView(
                R.id.username, R.string.prompt_email
            )
    }

    @Test
    fun seesPasswordText() {
        foundationActivityRobot
            .seesHintTextInTextView(
                R.id.password, R.string.prompt_password
            )
    }

    @Test
    fun seesLoginButton() {
        foundationActivityRobot
            .seesTextInTextView(
                R.id.login, R.string.action_sign_in_short
            )
    }

    @Test
    fun seesSignUpButton() {
        foundationActivityRobot
            .seesTextInTextView(
                R.id.signUp, R.string.action_register
            )
    }

}
