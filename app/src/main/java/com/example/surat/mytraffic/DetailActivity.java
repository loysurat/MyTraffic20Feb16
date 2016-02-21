package com.example.surat.mytraffic;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    // Explicit

    private TextView titleTextView, detailTextView;
    private ImageView trafficImageView;
    private Button preButton, backButton, nextButton;
    private  int[] iconInts;
    private String[] titleStrings,detailStrings;
    private int myIndexAnInt;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Bind Widget
        bindWidget();

        //ShowView
        ShowView();

        buttonController();

    }//Main method

    private void buttonController() {
        preButton.setOnClickListener(this);
        backButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);

    }

    private void ShowView() {
        //Receive Value From Intent
        titleStrings = getIntent().getStringArrayExtra("Title");
        iconInts = getIntent().getIntArrayExtra("Image");
        myIndexAnInt = getIntent().getIntExtra("Index", 0);

        detailStrings = getResources().getStringArray(R.array.detail_long);
        changView(myIndexAnInt);

    }

    private void changView(int myIndexAnInt) {
        titleTextView.setText(titleStrings[myIndexAnInt]);
        trafficImageView.setImageResource(iconInts[myIndexAnInt]);
        detailTextView.setText(detailStrings[myIndexAnInt]);
    }

    private void bindWidget() {

        titleTextView = (TextView) findViewById(R.id.textView4);
        detailTextView = (TextView) findViewById(R.id.textView5);
        trafficImageView = (ImageView) findViewById(R.id.imageView2);
        preButton = (Button) findViewById(R.id.button2);
        backButton = (Button) findViewById(R.id.button3);
        nextButton = (Button) findViewById(R.id.button4);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button2:

                myIndexAnInt -=1;
                if (myIndexAnInt<0) {
                    myIndexAnInt = 19;
                }
                changView(myIndexAnInt);
                break;

            case R.id.button3: finish();
                break;

            case R.id.button4:
                myIndexAnInt +=1;
                if (myIndexAnInt>=20) {
                    myIndexAnInt = 0;
                }
                changView(myIndexAnInt);
                break;


        } //switch

    }//onclick
}//Main Class
