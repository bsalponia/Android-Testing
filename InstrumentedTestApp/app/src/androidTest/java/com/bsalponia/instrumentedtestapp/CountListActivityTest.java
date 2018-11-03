package com.bsalponia.instrumentedtestapp;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class CountListActivityTest {

    @Rule
    public ActivityTestRule<CountListActivity> activityTestRule= new ActivityTestRule<>(CountListActivity.class);

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void clickGridItem_OpensCountItemActivity(){

        /*adapter view test in gridview
        * find the view at position 1 and perform click*/
        int position= 1;
        Espresso.onData(Matchers.anything()).inAdapterView(ViewMatchers.withId(R.id.gridView))
                .atPosition(position).perform(ViewActions.click());
        //check if the count in txtCount equal to--> 12 in the CountItemActivity
        Espresso.onView(ViewMatchers.withId(R.id.txtCount)).check(ViewAssertions.matches(ViewMatchers.withText("12")));
    }

    @After
    public void tearDown() throws Exception {
    }
}