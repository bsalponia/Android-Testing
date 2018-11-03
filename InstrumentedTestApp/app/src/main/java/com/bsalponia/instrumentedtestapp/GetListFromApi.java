package com.bsalponia.instrumentedtestapp;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;


import com.bsalponia.instrumentedtestapp.IdlingResource.SimpleIdlingResource;
import com.bsalponia.instrumentedtestapp.model.Item;

import java.util.ArrayList;

public class GetListFromApi {

    private static final int DELAY_TIME= 3000;           //3 seconds

    private static ArrayList<Item> list;

    public interface DelayerCallback{
        void onDone(ArrayList<Item> list);
    }

    public static void fetchList(Context context,
                          final SimpleIdlingResource idlingResource,
                          final DelayerCallback callback){
        if(idlingResource!=null){
            idlingResource.setIdleState(false);
        }

        //notify user that we are fetching data
        Toast.makeText(context, "Fetching Data, please wait..", Toast.LENGTH_SHORT).show();

        list= new ArrayList<>();
        list.add(new Item(4, "28-10-2018"));
        list.add(new Item(12, "27-10-2018"));
        list.add(new Item(7, "26-10-2018"));
        list.add(new Item(13, "25-10-2018"));
        list.add(new Item(5, "24-10-2018"));
        list.add(new Item(9, "23-10-2018"));
        list.add(new Item(6, "22-10-2018"));
        list.add(new Item(11, "21-10-2018"));
        list.add(new Item(8, "20-10-2018"));

        Runnable runnable= new Runnable() {
            @Override
            public void run() {
                if(callback!=null){
                    callback.onDone(list);
                    if(idlingResource!=null){
                        idlingResource.setIdleState(true);
                    }
                }
            }
        };
        new Handler().postDelayed(runnable, DELAY_TIME);
    }
}
