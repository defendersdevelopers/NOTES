package com.defenders.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class ScienceActivity extends AppCompatActivity {

 Button S1 ;
 Button S2;
 Button S3;
    Button S4;
    Button S5; Button S6; Button S7; Button S8; Button S9; Button S10; Button S11; Button S12; Button S13;
    Button S14;Button S15;Button S16; Button S17;

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onResume() {
        super.onResume();
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }

    }
    AdView mAdView1,mAdView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getResources().getString(R.string.interstitial2));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());




        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView1 = findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView1.loadAd(adRequest);

        mAdView2 = findViewById(R.id.adView3);
        AdRequest adRequest2 = new AdRequest.Builder().build();
        mAdView2.loadAd(adRequest2);



        S1 = (Button) findViewById(R.id.button1);
        S1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScienceActivity.this, PdfActivity.class);
                intent.putExtra("pdf_name","Cp1");
                startActivity(intent);

            }
        });

        S2 = (Button) findViewById(R.id.button2);
        S2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScienceActivity.this, PdfActivity.class);
                intent.putExtra("pdf_name","Cp2");
                startActivity(intent);

            }
        });


        S3 = (Button) findViewById(R.id.button3);
        S3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScienceActivity.this, PdfActivity.class);
                intent.putExtra("pdf_name","Cp3");
                startActivity(intent);

            }
        });

        S4 = (Button) findViewById(R.id.button4);
        S4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScienceActivity.this, PdfActivity.class);
                intent.putExtra("pdf_name","Cp4");
                startActivity(intent);

            }
        });

        S5 = (Button) findViewById(R.id.button5);
        S5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScienceActivity.this, PdfActivity.class);
                intent.putExtra("pdf_name","Cp5");
                startActivity(intent);

            }
        });

        S6 = (Button) findViewById(R.id.button6);
        S6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScienceActivity.this, PdfActivity.class);
                intent.putExtra("pdf_name","Cp6");
                startActivity(intent);

            }
        });

        S7 = (Button) findViewById(R.id.button7);
        S7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScienceActivity.this, PdfActivity.class);
                intent.putExtra("pdf_name","Cp7");
                startActivity(intent);

            }
        });


        S8 = (Button) findViewById(R.id.button8);
        S8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScienceActivity.this, PdfActivity.class);
                intent.putExtra("pdf_name","Cp8");
                startActivity(intent);

            }
        });

        S9 = (Button) findViewById(R.id.button9);
        S9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScienceActivity.this, PdfActivity.class);
                intent.putExtra("pdf_name","Cp9");
                startActivity(intent);

            }
        });


        S10 = (Button) findViewById(R.id.button10);
        S10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScienceActivity.this, PdfActivity.class);
                intent.putExtra("pdf_name","Cp10");
                startActivity(intent);

            }
        });

        S11 = (Button) findViewById(R.id.button11);
        S11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScienceActivity.this, PdfActivity.class);
                intent.putExtra("pdf_name","Cp11");
                startActivity(intent);

            }
        });

        S12 = (Button) findViewById(R.id.button12);
        S12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScienceActivity.this, PdfActivity.class);
                intent.putExtra("pdf_name","Cp12");
                startActivity(intent);

            }
        });

        S13 = (Button) findViewById(R.id.button13);
        S13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScienceActivity.this, PdfActivity.class);
                intent.putExtra("pdf_name","Cp13");
                startActivity(intent);

            }
        });


        S14 = (Button) findViewById(R.id.button14);
        S14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScienceActivity.this, PdfActivity.class);
                intent.putExtra("pdf_name","Cp14");
                startActivity(intent);

            }
        });


        S15= (Button) findViewById(R.id.button15);
        S15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScienceActivity.this, PdfActivity.class);
                intent.putExtra("pdf_name","Cp15");
                startActivity(intent);

            }
        });

        S16= (Button) findViewById(R.id.button16);
        S16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScienceActivity.this, PdfActivity.class);
                intent.putExtra("pdf_name","Cp16");
                startActivity(intent);

            }
        });


        S17= (Button) findViewById(R.id.button17);
        S17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScienceActivity.this, PdfActivity.class);
                intent.putExtra("pdf_name","Cp17");
                startActivity(intent);

            }
        });
    }}
