package com.deloittedigital.automation.benchmark

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.junit.Assert

class LoginDialog {

    //UI Elements
    fun emailAddress(): ViewInteraction {
        return onView(withId(R.id.username))
    }

    fun password(): ViewInteraction {
        return onView(withId(R.id.password))
    }

    fun loginButton(): ViewInteraction {
        return onView(withId(R.id.login))
    }

    fun signUpFromLoginButton(): ViewInteraction {
        return onView(withId(R.id.signUp))
    }

    //Common functionality
    fun enterEmailAddress(emailAddress: String) {
        Assert.assertNotNull(emailAddress, "Email address should not be null")
        emailAddress()
            .perform(ViewActions.typeText(emailAddress), ViewActions.closeSoftKeyboard())
    }

    fun enterPassword(password: String) {
        Assert.assertNotNull(password, "Password should not be null")
        password()
            .perform(ViewActions.typeText(password), ViewActions.closeSoftKeyboard())
    }


    fun pressLoginButton() {
        loginButton().check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        loginButton().perform(click())
    }

}
