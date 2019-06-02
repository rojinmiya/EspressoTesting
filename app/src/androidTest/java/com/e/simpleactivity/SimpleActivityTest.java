package com.e.simpleactivity;

import android.support.test.runner.AndroidJUnit4;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class SimpleActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> testRule=new ActivityTestRule<>(MainActivity.class);
    private String mText = "Hello";

    @Test
    public void TestUI() throws Exception{
        onView(withId(R.id.etText)).perform(typeText(mText));

        closeSoftKeyboard();

        onView(withId(R.id.btnClick)).perform(click());

        onView(withId(R.id.tvDisplay)).check(matches(withText(mText)));
    }



}
