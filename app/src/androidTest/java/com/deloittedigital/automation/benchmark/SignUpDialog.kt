package com.deloittedigital.automation.benchmark

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import org.junit.Assert

class SignUpDialog {

    //UI Elements
    private fun firstName(): ViewInteraction {
        return Espresso.onView(ViewMatchers.withId(R.id.editTextFirstName))
    }

    private fun lastName(): ViewInteraction {
        return Espresso.onView(ViewMatchers.withId(R.id.editTextLastName))
    }

    private fun mobileNumber(): ViewInteraction {
        return Espresso.onView(ViewMatchers.withId(R.id.editTextMobileNo))
    }

    private fun emailAddress(): ViewInteraction {
        return Espresso.onView(ViewMatchers.withId(R.id.editTextSignUpEmailAddress))
    }

    private fun password(): ViewInteraction {
        return Espresso.onView(ViewMatchers.withId(R.id.editTextSignUpPassword))
    }

    private fun signUpButton(): ViewInteraction {
        return Espresso.onView(ViewMatchers.withId(R.id.btnCreateAccount))
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

    fun enterFirstName(firstName: String) {
        Assert.assertNotNull(firstName, "First Name should not be null")
        firstName()
            .perform(ViewActions.typeText(firstName), ViewActions.closeSoftKeyboard())
    }

    fun enterLastName(lastName: String) {
        Assert.assertNotNull(lastName, "Last Name should not be null")
        lastName()
            .perform(ViewActions.typeText(lastName), ViewActions.closeSoftKeyboard())
    }

    fun enterMobileNumber(mobileNo: String) {
        Assert.assertNotNull(mobileNo, "Mobile No should not be null")
        mobileNumber()
            .perform(ViewActions.typeText(mobileNo), ViewActions.closeSoftKeyboard())
    }

    fun pressCreateAccountButton() {
        signUpButton().check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        signUpButton().perform(ViewActions.click())
    }

}
