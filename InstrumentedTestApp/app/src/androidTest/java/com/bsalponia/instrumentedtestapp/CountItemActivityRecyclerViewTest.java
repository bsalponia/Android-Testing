package com.bsalponia.instrumentedtestapp;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;

@RunWith(AndroidJUnit4.class)
public class CountItemActivityRecyclerViewTest {

    private static final String VALUE= "frequently occur that pleasures have to be repudiate";

    @Rule
    public ActivityTestRule<CountItemActivity> activityTestRule= new ActivityTestRule<>(CountItemActivity.class);

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void ScrollToPosition_CheckText(){

        int position= 2;
        /*find the recyclerview
        * scroll to position*/
        Espresso.onView(ViewMatchers.withId(R.id.recycler_))
                .perform(RecyclerViewActions.scrollToPosition(position));

        /*match the VAULE with displayed view having the text*/
        Espresso.onView(ViewMatchers.withText(VALUE)).check(ViewAssertions.matches(isDisplayed()));
    }

    @After
    public void tearDown() throws Exception {

    }
}