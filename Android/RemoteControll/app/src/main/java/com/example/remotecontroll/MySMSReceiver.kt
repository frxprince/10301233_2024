package com.example.remotecontroll

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class MySMSReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
   Log.v("status","SMS Received!!")
    }
}