package com.deloittedigital.automation.benchmark

import androidx.test.espresso.IdlingPolicies
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.deloittedigital.automation.benchmark.rules.TestAppIntentsTestRule
import com.deloittedigital.automation.benchmark.ui.MainActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.TimeUnit

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Rule
    val intentsTestRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Rule
    val mockWebServerRule: MockWebServerRule = MockWebServerRule()

    private val mockWebServerRobot: MockWebServerRobot = MockWebServerRobot(mockWebServerRule)
    private val foundationActivityRobot: FoundationActivityRobot = FoundationActivityRobot()

    @Before
    fun setup() {
        IdlingPolicies.setIdlingResourceTimeout(2, TimeUnit.MINUTES)
        foundationActivityRobot
            .launchesActivity(intentsTestRule)
    }

    @After
    fun tearDown() {
        IdlingPolicies.setIdlingResourceTimeout(60, TimeUnit.SECONDS)
    }

    @Test
    fun seesMyTripsTitle() {
        foundationActivityRobot
            .seesTextInTextView(
                R.id.btnLoginNavigate, R.string.action_sign_in_short
            )
    }

}
