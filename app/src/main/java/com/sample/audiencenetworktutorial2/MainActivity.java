package com.sample.audiencenetworktutorial2;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.ads.*;

public class MainActivity extends AppCompatActivity implements RewardedVideoAdListener {
    TextView tv;
    private final String TAG = MainActivity.class.getSimpleName();
    private RewardedVideoAd rewardedVideoAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.tv);
        //rewardedVideoAd = new RewardedVideoAd(this, "");
        loadRewardedVideoAd();
        /*rewardedVideoAd.setAdListener(new RewardedVideoAdListener() {
            @Override
            public void onError(Ad ad, AdError error) {
                // Rewarded video ad failed to load
                Log.e(TAG, "Rewarded video ad failed to load: " + error.getErrorMessage());
                Toast.makeText(MainActivity.this,"Rewarded video failed to load", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Rewarded video ad is loaded and ready to be displayed
                Log.d(TAG, "Rewarded video ad is loaded and ready to be displayed!");
                Toast.makeText(MainActivity.this,"Rewarded video ad is loaded and ready to be displayed!", Toast.LENGTH_SHORT).show();

                // Rewarded video ad is loaded and ready to be displayed
                rewardedVideoAd.show();
            }

            @Override
            public void onAdClicked(Ad ad) {
                // Rewarded video ad clicked
                Log.d(TAG, "Rewarded video ad clicked!");
                Toast.makeText(MainActivity.this,"Rewarded video ad clicked!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Rewarded Video ad impression - the event will fire when the
                // video starts playing
                Log.d(TAG, "Rewarded video ad impression logged!");
                Toast.makeText(MainActivity.this,"Rewarded video ad impression logged!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedVideoCompleted() {
                // Rewarded Video View Complete - the video has been played to the end.
                // You can use this event to initialize your reward
                Log.d(TAG, "Rewarded video completed!");
                Toast.makeText(MainActivity.this,"Rewarded video completed!", Toast.LENGTH_SHORT).show();

                // Call method to give reward
                // giveReward();
            }

            @Override
            public void onRewardedVideoClosed() {
                // The Rewarded Video ad was closed - this can occur during the video
                // by closing the app, or closing the end card.
                Log.d(TAG, "Rewarded video ad closed!");
                Toast.makeText(MainActivity.this,"Rewarded video ad closed!", Toast.LENGTH_SHORT).show();
            }
        });
        */

        rewardedVideoAd.loadAd();

        if (rewardedVideoAd != null || rewardedVideoAd.isAdLoaded()) {
            rewardedVideoAd.show();
        }

    }

    private void loadRewardedVideoAd() {
        rewardedVideoAd = new RewardedVideoAd(MainActivity.this, "");
        rewardedVideoAd.setAdListener(MainActivity.this);
        rewardedVideoAd.loadAd();
    }

    /*private void showAdWithDelay() {
        *//*Here is an example for displaying the ad with delay;
          Please do not copy the Handler into your project
        *//*
        //Handler handler = new Handler();
        Handler handler = null;
        handler.postDelayed(new Runnable() {
            public void run() {
                // Check if rewardedVideoAd has been loaded successfully
                if(rewardedVideoAd == null || !rewardedVideoAd.isAdLoaded()) {
                    return;
                }
                // Check if ad is already expired or invalidated, and do not show ad if that is the case. You will not get paid to show an invalidated ad.
                if(rewardedVideoAd.isAdInvalidated()) {
                    return;
                }
                rewardedVideoAd.show();
            }
        }, 1000 * 60 * 15); // Show the ad after 15 minutes
    }*/

    @Override
    protected void onDestroy() {
        if (rewardedVideoAd != null) {
            rewardedVideoAd.destroy();
            rewardedVideoAd = null;
        }
        super.onDestroy();
    }

    @Override
    public void onRewardedVideoCompleted() {
        // Rewarded Video View Complete - the video has been played to the end.
        // You can use this event to initialize your reward
        Log.d(TAG, "Rewarded video completed!");
        Toast.makeText(MainActivity.this,"Rewarded video completed!", Toast.LENGTH_SHORT).show();

        // Call method to give reward
        // giveReward();
    }

    @Override
    public void onError(Ad ad, AdError adError) {
        // Rewarded video ad failed to load
        Log.e(TAG, "Rewarded video ad failed to load: " + adError.getErrorMessage());
        Toast.makeText(MainActivity.this,"Rewarded video failed to load", Toast.LENGTH_SHORT).show();
        tv.setText(adError.getErrorMessage());
    }

    @Override
    public void onAdLoaded(Ad ad) {
        // Rewarded video ad is loaded and ready to be displayed
        Log.d(TAG, "Rewarded video ad is loaded and ready to be displayed!");
        Toast.makeText(MainActivity.this,"Rewarded video ad is loaded and ready to be displayed!", Toast.LENGTH_SHORT).show();

        // Rewarded video ad is loaded and ready to be displayed
        rewardedVideoAd.show();
    }

    @Override
    public void onAdClicked(Ad ad) {
        // Rewarded video ad clicked
        Log.d(TAG, "Rewarded video ad clicked!");
        Toast.makeText(MainActivity.this,"Rewarded video ad clicked!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoggingImpression(Ad ad) {
        // Rewarded Video ad impression - the event will fire when the
        // video starts playing
        Log.d(TAG, "Rewarded video ad impression logged!");
        Toast.makeText(MainActivity.this,"Rewarded video ad impression logged!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoClosed() {
        // The Rewarded Video ad was closed - this can occur during the video
        // by closing the app, or closing the end card.
        Log.d(TAG, "Rewarded video ad closed!");
        Toast.makeText(MainActivity.this,"Rewarded video ad closed!", Toast.LENGTH_SHORT).show();
    }
}
