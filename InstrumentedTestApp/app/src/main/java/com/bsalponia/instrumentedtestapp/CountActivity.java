package com.bsalponia.instrumentedtestapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class CountActivity extends AppCompatActivity {

    private static int count= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);

        Button btnAdd= findViewById(R.id.btnAdd);
        Button btnMinus= findViewById(R.id.btnMinus);
        final TextView txtCount= findViewById(R.id.txtCount);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtCount.setText(Integer.toString(++count));
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtCount.setText(Integer.toString(--count));            //negative value is acceptable
            }
        });


        Button btnPrevious= findViewById(R.id.btnPrevious);
        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), CountListActivity.class));
            }
        });


        Calendar cal= Calendar.getInstance();       //creating calendar instance



        Log.i("hourofday", "value: "+ cal.get(Calendar.HOUR) +  " "+ cal.get(Calendar.HOUR_OF_DAY));


                cal.add(Calendar.HOUR_OF_DAY, 5);
        cal.add(Calendar.MINUTE, 30);


        Log.i("hourofday", "value: "+ cal.get(Calendar.HOUR) +  " "+ cal.get(Calendar.HOUR_OF_DAY));
    }
}
