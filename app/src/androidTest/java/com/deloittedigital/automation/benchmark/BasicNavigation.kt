package com.deloittedigital.automation.benchmark

import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import org.hamcrest.Matcher

class BasicNavigation{
    private var mHomePageItems: MenuContainer? = null

    fun BasicNavigation() {
        mHomePageItems = MenuContainer()
    }

    fun tapLoginButton() {
        mHomePageItems?.loginButton()?.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        mHomePageItems?.loginButton()?.perform(ViewActions.click())
    }

    fun tapSignUpButton() {
        mHomePageItems?.signUpButton()?.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        mHomePageItems?.signUpButton()?.perform(ViewActions.click())
    }

    fun withCustomConstraints(
        action: ViewAction,
        constraints: Matcher<View>
    ): ViewAction? {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return constraints
            }

            override fun getDescription(): String {
                return action.description
            }

            override fun perform(
                uiController: UiController,
                view: View
            ) {
                action.perform(uiController, view)
            }
        }
    }
}
