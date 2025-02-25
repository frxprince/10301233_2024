package com.example.remotecontroll

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.provider.Telephony
import android.util.Log

class MySMSReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
   Log.v("status","SMS Received!!")
   var Mp = MediaPlayer()

   val msg= Telephony.Sms.Intents.getMessagesFromIntent(intent)[0]
  val i=Intent(context,MainActivity::class.java)
  i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
  i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
   if (msg.displayMessageBody == "cat"){
      // context.startActivity(i)
       Mp=MediaPlayer.create(context,R.raw.cat)
       Mp.start()
   }
        if (msg.displayMessageBody == "alarm"){
            // context.startActivity(i)
            Mp=MediaPlayer.create(context,R.raw.alarm)
            Mp.start()
        }
        if (msg.displayMessageBody == "mju"){
   val j= Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mju.ac.th"))
            j.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            j.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            context.startActivity(j)
        }


    }
}