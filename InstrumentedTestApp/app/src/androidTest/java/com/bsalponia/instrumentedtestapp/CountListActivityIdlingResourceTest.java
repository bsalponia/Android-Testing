package com.bsalponia.instrumentedtestapp;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.IdlingResource;
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

import static org.hamcrest.CoreMatchers.anything;


@RunWith(AndroidJUnit4.class)
public class CountListActivityIdlingResourceTest {

    @Rule
    public ActivityTestRule<CountListActivity> activityTestRule= new ActivityTestRule<>(CountListActivity.class);

    private IdlingResource idlingResource;

    @Before
    public void setUp() throws Exception {
        /*get and register the idling resource*/
        idlingResource= activityTestRule.getActivity().getIdlingResource();
        IdlingRegistry.getInstance().register(idlingResource);
    }

    @Test
    public void idlingResourceTest(){

        /*Performing click on item 1*/
        int position= 1;
        Espresso.onData(anything()).inAdapterView(ViewMatchers.withId(R.id.gridView)).atPosition(position).perform(ViewActions.click());

        /*Now this txtCount, is in CountItemActivity but we don't have to mention it here, that's the beauty of Espresso.*/
        Espresso.onView(ViewMatchers.withId(R.id.txtCount)).check(ViewAssertions.matches(ViewMatchers.withText("12")));
    }

    @After
    public void tearDown() throws Exception {
        if(idlingResource!=null)
            IdlingRegistry.getInstance().unregister(idlingResource);
    }
}