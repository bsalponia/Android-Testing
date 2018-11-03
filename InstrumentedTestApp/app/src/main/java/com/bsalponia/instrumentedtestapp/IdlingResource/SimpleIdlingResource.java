package com.bsalponia.instrumentedtestapp.IdlingResource;

import android.support.annotation.Nullable;
import android.support.test.espresso.IdlingResource;

import java.util.concurrent.atomic.AtomicBoolean;

public class SimpleIdlingResource implements IdlingResource {

    @Nullable
    private ResourceCallback callback;

    /*Idleness is controlled with this boolean.
    * So, this is thread safe
    * normal boolean is also thread safe in java*/
    private AtomicBoolean isIdleNow= new AtomicBoolean(true);

    @Override
    public String getName() {
        return this.getClass().getName();
    }

    @Override
    public boolean isIdleNow() {
        return isIdleNow.get();
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback callback) {
        this.callback= callback;
    }

    /*When isIdleNow is false then there is a pending background task
    * if isIdleNow is true that means no background task.*/
    public void setIdleState(boolean isIdle){
        isIdleNow.set(isIdle);
        if(isIdle &&
                callback!=null){
            callback.onTransitionToIdle();
        }
    }
}
