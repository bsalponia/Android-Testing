package com.bsalponia.instrumentedtestapp;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.intent.matcher.IntentMatchers;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.core.AllOf;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.intent.Intents.intending;
import static org.hamcrest.core.IsNot.not;

@RunWith(AndroidJUnit4.class)
public class CountItemActivityTest {

    private static final String emailMessage= "Looking started he up perhaps against. How remainder all additions get elsewhere resources. One missed shy wishes supply design answer formed. Prevent on present hastily passage an subject in be. Be happiness arranging so newspaper defective affection ye. Families blessing he in to no daughter.";

    /*We can use ActivityTestRule as well but have to call Intent.init() in @Before & Intent.release() in @After.
    * IntentsTestRule is an extension of ActivityTestRule, so here we don't have to initialize the intent.*/
    @Rule
    public IntentsTestRule<CountItemActivity> intentsTestRule= new IntentsTestRule<>(CountItemActivity.class);

    @Before
    public void setUp() throws Exception {
        /*Intent Stub- passing our own value, mimicking the intent response from other app activity like contacts*/
        intending(not(IntentMatchers.isInternal())).respondWith(new Instrumentation.ActivityResult(Activity.RESULT_OK, null));
    }

    @Test
    public void buttonSendEmail_IntentVerification(){

        Espresso.onView(ViewMatchers.withId(R.id.btnEmail)).perform(ViewActions.click());
        /*Intent Verification- just like mockito, Mockito.verify() method*/
        Intents.intended(AllOf.allOf(IntentMatchers.hasAction(Intent.ACTION_SENDTO),
                IntentMatchers.hasExtra(Intent.EXTRA_TEXT, emailMessage)));
    }

    @After
    public void tearDown() throws Exception {
    }
}