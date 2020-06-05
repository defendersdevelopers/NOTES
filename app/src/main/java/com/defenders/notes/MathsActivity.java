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

public class MathsActivity extends AppCompatActivity {

    Button M1; Button M2; Button M3; Button M4; Button M5; Button M6; Button M7; Button M8; Button M9;
    Button M10; Button M11; Button M12; Button M13;
    AdView mAdView1,mAdView2;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths);


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getResources().getString(R.string.interstitial1));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());




        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView1 = findViewById(R.id.adView4);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView1.loadAd(adRequest);


        mAdView2 = findViewById(R.id.adView5);
        AdRequest adRequest2 = new AdRequest.Builder().build();
        mAdView2.loadAd(adRequest2);


        M1 = (Button) findViewById(R.id.button01);
        M1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MathsActivity.this, PdfActivity.class);
                intent.putExtra("pdf_name","Mp1");
                startActivity(intent);

            }
        });


        M2 = (Button) findViewById(R.id.button02);
        M2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MathsActivity.this, PdfActivity.class);
                intent.putExtra("pdf_name","Mp2");
                startActivity(intent);

            }
        });

        M3 = (Button) findViewById(R.id.button03);
        M3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MathsActivity.this, PdfActivity.class);
                intent.putExtra("pdf_name","Mp3");
                startActivity(intent);

            }
        });

        M4 = (Button) findViewById(R.id.button04);
        M4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MathsActivity.this, PdfActivity.class);
                intent.putExtra("pdf_name","Mp4");
                startActivity(intent);

            }
        });

        M5 = (Button) findViewById(R.id.button05);
        M5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MathsActivity.this, PdfActivity.class);
                intent.putExtra("pdf_name","Mp5");
                startActivity(intent);

            }
        });

        M6 = (Button) findViewById(R.id.button06);
        M6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MathsActivity.this, PdfActivity.class);
                intent.putExtra("pdf_name","Mp6");
                startActivity(intent);

            }
        });


        M7 = (Button) findViewById(R.id.button07);
        M7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MathsActivity.this, PdfActivity.class);
                intent.putExtra("pdf_name","Mp7");
                startActivity(intent);

            }
        });


        M8 = (Button) findViewById(R.id.button08);
        M8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MathsActivity.this, PdfActivity.class);
                intent.putExtra("pdf_name","Mp8");
                startActivity(intent);

            }
        });

        M9 = (Button) findViewById(R.id.button09);
        M9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MathsActivity.this, PdfActivity.class);
                intent.putExtra("pdf_name","Mp9");
                startActivity(intent);

            }
        });

        M10 = (Button) findViewById(R.id.button010);
        M10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MathsActivity.this, PdfActivity.class);
                intent.putExtra("pdf_name","Mp12");
                startActivity(intent);
            }
        });


        M11 = (Button) findViewById(R.id.button011);
        M11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MathsActivity.this, PdfActivity.class);
                intent.putExtra("pdf_name","Mp13");
                startActivity(intent);

            }
        });


        M12 = (Button) findViewById(R.id.button012);
        M12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MathsActivity.this, PdfActivity.class);
                intent.putExtra("pdf_name","Mp15");
                startActivity(intent);

            }
        });

        M13 = (Button) findViewById(R.id.button013);
        M13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MathsActivity.this, PdfActivity.class);
                intent.putExtra("pdf_name","Mps16");
                startActivity(intent);
            }
        });
    }


}
