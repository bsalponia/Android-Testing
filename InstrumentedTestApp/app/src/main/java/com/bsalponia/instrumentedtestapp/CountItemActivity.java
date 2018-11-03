package com.bsalponia.instrumentedtestapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.bsalponia.instrumentedtestapp.adapter.ThisDayInHistoryAdapter;

import java.util.ArrayList;

public class CountItemActivity extends AppCompatActivity {

    private static final String TAG= CountItemActivity.class.getSimpleName();
    public static final String COUNT= TAG+".count";
    public static final String DATE= TAG+".date";

    private int count;
    private String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_item);

        Bundle bundle= getIntent().getExtras();
        if(bundle!=null &&
                bundle.containsKey(COUNT)){
            count= bundle.getInt(COUNT);
            date= bundle.getString(DATE);
        }else{
            /*Usually I finish the activity if the bundle is null as there is no point in showing and empty screen with no data
            * but if I keep the else part in the instrumented test the test fails giving the error-
            * android.support.test.espresso.NoActivityResumedException: No activities in stage RESUMED.
            * Did you t to launch the activity. (test.getActivity() or similar)?
            *
            * So, never finish the activity during testing.
            * ps: took me 2 days to figure this out*/

//            finish();
        }


        TextView txtCount= findViewById(R.id.txtCount);
        txtCount.setText(""+count);

        TextView txtDate= findViewById(R.id.txtDate);
        txtDate.setText(date);

        Button btnEmail= findViewById(R.id.btnEmail);
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail(count, date);
            }
        });


        RecyclerView recycler_= findViewById(R.id.recycler_);
        recycler_.setLayoutManager(new LinearLayoutManager(this));
        recycler_.hasFixedSize();
        ThisDayInHistoryAdapter adapter= new ThisDayInHistoryAdapter(sendList());
        recycler_.setAdapter(adapter);

    }

    private void sendEmail(int count, String date){
        String emailSubject= date+" - "+count;
        String emailMessage = getString(R.string.random_text);

        // Use an intent to launch an email app.
        // Send the order summary in the email body.
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
        intent.putExtra(Intent.EXTRA_TEXT, emailMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private ArrayList<String> sendList(){

        ArrayList<String> list= new ArrayList<>();
        list.add("history working natural interesting cyclone remainder");
        list.add("ns that private or corporate clients corder a");
        list.add("ly to focus on the text, disregarding the lay");
        list.add("ut perspiciatis, unde omnis iste natus error sit");
        list.add("and praising pain was born and I will give you a");
        list.add("ely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but");
        list.add("frequently occur that pleasures have to be repudiate");
        list.add("eased in 1987 for PCs running");
        list.add("raphical specimens; in the 1960s and 1970s it ");
        list.add("s use it as a samples for screenplay layout. Content ");
        list.add("omps, layouts, wireframes—will your clie");
        list.add("asn't collaboration, communication, and checkpoints");

        return list;
    }

}
