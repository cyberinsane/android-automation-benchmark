package com.deloittedigital.automation.benchmark

import androidx.annotation.IntegerRes
import androidx.annotation.StringRes
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.CoreMatchers.allOf

class FoundationActivityRobot : BaseActivityRobot<FoundationActivityRobot>() {

    fun seesTextInTextView(@IntegerRes btnId: Int, @StringRes btnName: Int): FoundationActivityRobot {

        Espresso.onView(withId(btnId))
            .check(
                ViewAssertions.matches(
                    allOf(
                        isDisplayed(),
                        withText(btnName)
                    )
                )
            )
        return this

    }

    fun seesHintTextInTextView(@IntegerRes btnId: Int, @StringRes btnName: Int): FoundationActivityRobot {

        Espresso.onView(withId(btnId))
            .check(
                ViewAssertions.matches(
                    allOf(
                        isDisplayed(),
                        withHint(btnName)
                    )
                )
            )
        return this

    }

    override val spinnerId: Int
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
}
