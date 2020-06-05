package com.defenders.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

public class MainActivity extends AppCompatActivity {

    Button Science;
    Button Maths;
    Button btnDoubt,btnTution;



    AdView mAdView;
    private RewardedAd rewardedAd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        rewardedAd = new RewardedAd(this,
                getResources().getString(R.string.rewarded1));


        RewardedAdLoadCallback adLoadCallback = new RewardedAdLoadCallback() {
            @Override
            public void onRewardedAdLoaded() {
                Activity activityContext = MainActivity.this;
                RewardedAdCallback adCallback = new RewardedAdCallback() {
                    @Override
                    public void onRewardedAdOpened() {
                    }

                    @Override
                    public void onRewardedAdClosed() {
                    }

                    @Override
                    public void onUserEarnedReward(@NonNull RewardItem reward) {
                    }

                    @Override
                    public void onRewardedAdFailedToShow(int errorCode) {
                    }
                };
                rewardedAd.show(activityContext, adCallback);
            }

            @Override
            public void onRewardedAdFailedToLoad(int errorCode) {
                // Ad failed to load.
            }
        };
        rewardedAd.loadAd(new AdRequest.Builder().build(), adLoadCallback);


        btnDoubt = findViewById(R.id.btn_doubt);
        btnTution = findViewById(R.id.btn_tution);
        Science = (Button) findViewById(R.id.science);
        Science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScienceActivity.class);
                startActivity(intent);

            }
        });

        Maths = (Button) findViewById(R.id.maths);
        Maths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MathsActivity.class);
                startActivity(intent);

            }
        });


        btnDoubt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,DoubtActivity.class));
            }
        });

        btnTution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TuitionActivity.class));
            }
        });
    }
}
