package com.deloittedigital.automation.benchmark

import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.core.AllOf

class AlertDialogRobot {
    fun seesTitle(@IdRes titleId: Int, @StringRes titleStringRes: Int): AlertDialogRobot {
        Espresso.onView(ViewMatchers.withId(titleId))
            .check(
                ViewAssertions.matches(
                    AllOf.allOf(
                        ViewMatchers.isDisplayed(),
                        ViewMatchers.withText(titleStringRes)
                    )
                )
            )
        return this
    }

    fun seesTitle(@IdRes titleId: Int, title: String?): AlertDialogRobot {
        Espresso.onView(ViewMatchers.withId(titleId))
            .check(
                ViewAssertions.matches(
                    AllOf.allOf(
                        ViewMatchers.isDisplayed(),
                        ViewMatchers.withText(title)
                    )
                )
            )
        return this
    }

    fun seesMessage(@IdRes messageId: Int, @StringRes messageStringRes: Int): AlertDialogRobot {
        Espresso.onView(ViewMatchers.withId(messageId))
            .check(
                ViewAssertions.matches(
                    AllOf.allOf(
                        ViewMatchers.isDisplayed(),
                        ViewMatchers.withText(messageStringRes)
                    )
                )
            )
        return this
    }

    fun seesMessage(@IdRes messageId: Int, message: String?): AlertDialogRobot {
        Espresso.onView(ViewMatchers.withId(messageId))
            .check(
                ViewAssertions.matches(
                    AllOf.allOf(
                        ViewMatchers.isDisplayed(),
                        ViewMatchers.withText(message)
                    )
                )
            )
        return this
    }

    fun seesMessageDisplayed(@IdRes messageId: Int): AlertDialogRobot {
        Espresso.onView(ViewMatchers.withId(messageId))
            .check(
                ViewAssertions.matches(
                    AllOf.allOf(
                        ViewMatchers.isDisplayed()
                    )
                )
            )
        return this
    }

    fun seesText(@IdRes textIdRes: Int): AlertDialogRobot {
        Espresso.onView(ViewMatchers.withText(textIdRes))
            .inRoot(RootMatchers.isDialog())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        return this
    }

    fun seesButton(@IdRes button: Int, @StringRes buttonText: Int): AlertDialogRobot {
        Espresso.onView(ViewMatchers.withId(button))
            .check(
                ViewAssertions.matches(
                    AllOf.allOf(
                        ViewMatchers.isDisplayed(),
                        ViewMatchers.withText(buttonText)
                    )
                )
            )
        return this
    }

    fun clicksDialogButton(buttonText: String?): AlertDialogRobot {
        Espresso.onView(ViewMatchers.withText(buttonText))
            .perform(ViewActions.click())
        return this
    }

    fun clicksDialogButton(@StringRes buttonText: Int): AlertDialogRobot {
        Espresso.onView(ViewMatchers.withText(buttonText))
            .perform(ViewActions.click())
        return this
    }
}