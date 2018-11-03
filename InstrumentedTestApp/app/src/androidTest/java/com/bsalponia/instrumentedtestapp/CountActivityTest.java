package com.bsalponia.instrumentedtestapp;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class CountActivityTest {

    @Rule
    public ActivityTestRule<CountActivity> mainActivityRule= new ActivityTestRule<>(CountActivity.class);

    @Test
    public void counterButtonAddTest(){
        //find the view- perform action on view- then assert
        Espresso.onView(ViewMatchers.withId(R.id.btnAdd)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.txtCount)).check(ViewAssertions.matches(ViewMatchers.withText("1")));
    }

    @Test
    public void counterButtonMinusTest(){
        Espresso.onView(ViewMatchers.withId(R.id.btnMinus)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.txtCount)).check(ViewAssertions.matches(ViewMatchers.withText("0")));
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
}