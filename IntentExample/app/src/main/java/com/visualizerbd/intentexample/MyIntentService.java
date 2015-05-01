package com.visualizerbd.intentexample;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyIntentService extends IntentService {

    private static final String TAG = "com.visualizerbd.intentexample";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        // This is what this service does
        Log.d( TAG, "The service has started" );
        Log
    }
}
