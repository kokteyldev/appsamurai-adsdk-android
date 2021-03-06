package com.appsamurai.adsdk.sample.java;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

import com.appsamurai.ads.banner.AdView;
import com.appsamurai.ads.common.AdListener;
import com.appsamurai.ads.common.AdRequest;
import com.appsamurai.ads.common.MobileAds;

public class ProgrammaticBannerAdActivity extends AppCompatActivity {

    private AdView mAdView;
    private RelativeLayout adContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programmatic_banner_ad);

        // initialize Mobile Ads
        MobileAds.initialize(getApplicationContext(), "gJIwJ-T0Kst86Mw3JIk-1A");

        // get the container layout
        adContainer = findViewById(R.id.adContainer);

        // create an adview and set ad unit id
        mAdView = new AdView(this);
        mAdView.setAdUnitId("nnrgOQ4JmLRCuphTYTkRvg");

        // create a layout params and add ad view to the container view with this layout params
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(Utils.dpToPx(320), Utils.dpToPx(50));
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        params.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
        adContainer.addView(mAdView, params);

        // create an ad request and load ad with this ad request
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        // set an AdListener in order to track the state of the ad
        mAdView.setAdListener(new AdListener() {
            // Code to be executed when an ad finishes loading.
            @Override
            public void onAdLoaded() {
                Log.d(Utils.LOGTAG, "Ad Loaded: " + mAdView.getAdUnitId());
            }

            // Code to be executed when an ad request fails.
            @Override
            public void onAdFailedToLoad(int errorCode) {
                Log.d(Utils.LOGTAG, "Ad Failed To Load: " + mAdView.getAdUnitId() + " " + errorCode);
            }

            // Code to be executed when an ad opens an overlay that covers the screen.
            @Override
            public void onAdOpened() {
                Log.d(Utils.LOGTAG, "Ad Opened: " + mAdView.getAdUnitId());
            }

            // Code to be executed when the user has left the app.
            @Override
            public void onAdLeftApplication() {
                Log.d(Utils.LOGTAG, "Ad Left Application: " + mAdView.getAdUnitId());
            }

            // Code to be executed when when the user is about to return to the app after tapping on an ad.
            @Override
            public void onAdClosed() {
                Log.d(Utils.LOGTAG, "Ad Closed: " + mAdView.getAdUnitId());
            }
        });
    }
}
