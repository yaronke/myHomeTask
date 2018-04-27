package com.mytaxi.android_demo;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.android_demo.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)

public class LoginInstrumentedTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void logInUserPass() {
        onView(withId(R.id.edt_username))
                .perform(typeText("whiteelephant261"));
        onView(withId(R.id.edt_password))
                .perform(typeText("video1"));
        onView(withId(R.id.btn_login))
                .perform(click());
        onView(withId(R.id.textSearch))
                .perform(typeText("sa"), closeSoftKeyboard());
        onView(withText("Sarah Friedrich"))
                .inRoot(isPlatformPopup())
                .perform(click());
        onView(withId(R.id.textViewDriverName))
                .check(matches(withText("Sarah Friedrich")));
        onView(withId(R.id.fab))
                .perform(click());

    }

}
