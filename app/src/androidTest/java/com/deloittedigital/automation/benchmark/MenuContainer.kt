package com.deloittedigital.automation.benchmark

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.withId

class MenuContainer {

    fun loginButton(): ViewInteraction {
        return Espresso.onView(withId(R.id.login))
    }

    fun signUpButton(): ViewInteraction {
        return Espresso.onView(withId(R.id.signUp))
    }

}
