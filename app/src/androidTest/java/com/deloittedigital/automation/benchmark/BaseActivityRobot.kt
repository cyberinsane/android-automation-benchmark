package com.deloittedigital.automation.benchmark

import android.content.Intent
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule

abstract class BaseActivityRobot<T> {
    fun launchesActivity(rule: ActivityTestRule<*>): T {
        rule.launchActivity(null)
        return this as T
    }

    fun launchesActivityWithIntent(rule: IntentsTestRule<*>, intent: Intent?): T {
        rule.launchActivity(intent)
        return this as T
    }

    // Observation
    protected fun seesTitle(@IdRes toolbarId: Int, @StringRes titleResId: Int): T {
        Espresso.onView(ViewMatchers.withId(toolbarId))
            .check(ViewAssertions.matches(ToolbarMatchers.withToolbarTitle(titleResId)))
        return this as T
    }

    protected fun seesTitle(@IdRes toolbarId: Int, title: String?): T {
        Espresso.onView(ViewMatchers.withId(toolbarId))
            .check(ViewAssertions.matches(ToolbarMatchers.withToolbarTitle(title)))
        return this as T
    }

    fun seesBackButton(): T {
        Espresso.onView(ViewMatchers.withContentDescription("Navigate up")).check(
            ViewAssertions.matches(ViewMatchers.isDisplayed())
        )
        return this as T
    }

    // Interactions
    fun clicksUpButton(): T {
        Espresso.onView(ViewMatchers.withContentDescription("Navigate up"))
            .perform(ViewActions.click())
        return this as T
    }

    fun clicksBackButton(): T {
        Espresso.pressBack()
        return this as T
    }

    fun doesNotSeeLoadingSpinner(): T {
        Espresso.onView(ViewMatchers.withId(spinnerId)).check(ViewAssertions.doesNotExist())
        return this as T
    }

    @get:IdRes
    abstract val spinnerId: Int
}