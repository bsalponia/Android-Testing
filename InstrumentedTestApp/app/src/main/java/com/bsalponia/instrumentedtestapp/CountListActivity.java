package com.bsalponia.instrumentedtestapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.test.espresso.IdlingResource;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.bsalponia.instrumentedtestapp.IdlingResource.SimpleIdlingResource;
import com.bsalponia.instrumentedtestapp.adapter.CountListAdapter;
import com.bsalponia.instrumentedtestapp.model.Item;

import java.util.ArrayList;

public class CountListActivity extends AppCompatActivity {

    @Nullable
    private SimpleIdlingResource idlingResource;

    @NonNull
    public IdlingResource getIdlingResource() {
        if (idlingResource == null) {
            idlingResource = new SimpleIdlingResource();
        }
        return idlingResource;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_list);

        getIdlingResource();
    }

    /*In onStart() the activity is visible. */
    @Override
    protected void onStart() {
        super.onStart();
        GetListFromApi.fetchList(this, idlingResource, new GetListFromApi.DelayerCallback() {
            @Override
            public void onDone(ArrayList<Item> list) {
                GridView gridView= findViewById(R.id.gridView);
                CountListAdapter adapter= new CountListAdapter(gridView.getContext(), R.layout.grid_item, list);
                gridView.setAdapter(adapter);

                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Item item= (Item)parent.getItemAtPosition(position);

                        Intent intent= new Intent(view.getContext(), CountItemActivity.class);
                        intent.putExtra(CountItemActivity.COUNT, item.getCount());
                        intent.putExtra(CountItemActivity.DATE, item.getDate());
                        startActivity(intent);
                    }
                });
            }
        });
    }
}
