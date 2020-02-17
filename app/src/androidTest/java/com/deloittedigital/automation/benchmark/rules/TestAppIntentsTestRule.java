package com.deloittedigital.automation.benchmark.rules;

import android.app.Activity;
import android.content.Intent;

import androidx.test.espresso.intent.rule.IntentsTestRule;

import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra;

public class TestAppIntentsTestRule<T extends Activity> extends IntentsTestRule<T> {

    public TestAppIntentsTestRule(Class<T> clazz) {
        super(clazz, false, false);
    }

    public T launchActivity() {
        return super.launchActivity(null);
    }

    public T launchActivity(Intent intent) {
        return super.launchActivity(intent);
    }

    public <A extends Activity> void checkActivityLaunched(Class<A> activity) {
        intended(hasComponent(activity.getName()));
    }

    public <V> void checkIntentHasExtra(String key, V value) {
        intended(hasExtra(key, value));
    }
}
