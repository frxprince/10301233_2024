package com.example.smssender

import android.Manifest
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
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
if(checkSelfPermission(Manifest.permission.SEND_SMS)!=PackageManager.PERMISSION_GRANTED)
 requestPermissions(arrayOf(Manifest.permission.SEND_SMS),1234)
val txtPhonenumber= findViewById<EditText>(R.id.editTextNumber)
val txtMessage=findViewById<EditText>(R.id.editTextTextMultiLine)
val btn=findViewById<Button>(R.id.button)
val txtLog=findViewById<TextView>(R.id.textView)
val sendPI= PendingIntent.getBroadcast(this,0, Intent("SMS_SENT")
    ,PendingIntent.FLAG_IMMUTABLE)
val receivedPI=   PendingIntent.getBroadcast(this,0, Intent("SMS_DELIVERED")
    ,PendingIntent.FLAG_IMMUTABLE)

        btn.setOnClickListener {
val smsmanager=getSystemService(SmsManager::class.java)
smsmanager.sendTextMessage(txtPhonenumber.text.toString(),"55",txtMessage.text.toString(),
    sendPI,receivedPI)
}
val sent_receiver=object:SMSSent(){
    override fun show(msg: String) {
     txtLog.text="${txtLog.text} \n  $msg"
    }
}
registerReceiver(sent_receiver, IntentFilter("SMS_SENT"), RECEIVER_EXPORTED)
    }
abstract class SMSSent:BroadcastReceiver(){
    override fun onReceive(p0: Context?, p1: Intent?) {
      when(resultCode){
        RESULT_OK->show("The sms was sent")
        SmsManager.RESULT_ERROR_NO_SERVICE->show("No service")
        SmsManager.RESULT_ERROR_RADIO_OFF->show("Radio off")
        else->show("Unkown error")
      }
    }
 abstract fun show(msg:String)
}

}