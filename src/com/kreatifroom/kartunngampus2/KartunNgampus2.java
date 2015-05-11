/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
 */

package com.kreatifroom.kartunngampus2;

import android.os.Bundle;
import android.os.Handler;
import android.widget.LinearLayout;

import org.apache.cordova.*;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

public class KartunNgampus2 extends DroidGap
{
	private Handler mHandler = new Handler();
    private AdView adView;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // Set by <content src="index.html" /> in config.xml
        super.loadUrl(Config.getStartUrl());
        //super.loadUrl("file:///android_asset/www/index.html")
        super.setIntegerProperty("splashscreen", R.drawable.splash);
        super.loadUrl(Config.getStartUrl(), 5000);
        mHandler.postDelayed(new Runnable() {
            public void run() {
                doAdMob();
            }
        }, 5000);
    }
    
    private void doAdMob() {
        // Create the adView
        adView = new AdView(this, AdSize.BANNER, "a151c2e9b7815d7");
        // Lookup your LinearLayout - get the super.root
        LinearLayout layout = super.root;
        // Add the adView to it
        layout.addView(adView);
        // This centers the ads in landscape mode.        
        layout.setHorizontalGravity(android.view.Gravity.CENTER_HORIZONTAL);
        // Initiate a generic request to load it with an ad
        AdRequest request = new AdRequest();
        // and finally...     
        adView.loadAd(request);                    
    }
}

