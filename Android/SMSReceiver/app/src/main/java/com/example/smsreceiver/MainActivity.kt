package com.example.smsreceiver

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.Telephony
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
if(checkSelfPermission(Manifest.permission.RECEIVE_SMS)!= PackageManager.PERMISSION_GRANTED)
    requestPermissions(arrayOf(Manifest.permission.RECEIVE_SMS),12134)
val txt=findViewById<TextView>(R.id.textView)
val receiver_SMS= object:SMSReceiver(){
    override fun show(msg: String) {
        txt.text=msg
    }
}
 registerReceiver(receiver_SMS, IntentFilter("android.provider.Telephony.SMS_RECEIVED"))
    }
abstract class SMSReceiver:BroadcastReceiver(){
    override fun onReceive(p0: Context?, p1: Intent?) {
        val message=Telephony.Sms.Intents.getMessagesFromIntent(p1)[0]
        show("From:${message.displayOriginatingAddress}\nMessage:${message.displayMessageBody} ")
    }
abstract fun show(msg:String)
}
}