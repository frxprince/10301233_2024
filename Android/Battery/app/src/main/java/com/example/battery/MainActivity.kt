package com.example.battery

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
lateinit var  receiver:Myreceiver
abstract class Myreceiver:BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
     val battLevel=intent?.getIntExtra(BatteryManager.EXTRA_LEVEL,0)?:0
     val battScale=intent?.getIntExtra(BatteryManager.EXTRA_SCALE,1)?:1
     var battvalue=(battLevel/ battScale.toDouble()) * 100
     var usbStatus=intent?.getIntExtra(BatteryManager.EXTRA_STATUS,0)?:0
         updateUI(battvalue.toInt(),usbStatus)
    }
  abstract fun updateUI(battValue:Int,usbStatus:Int)
}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
      val txt=findViewById<TextView>(R.id.textView)
      val progress=findViewById<ProgressBar>(R.id.progressBar)
      progress.max=100
      progress.progress=50

   receiver=object : Myreceiver() {
            override fun updateUI(battValue: Int,usbStatus:Int) {
              progress.progress=battValue
    val usbMessage=when(usbStatus){
    BatteryManager.BATTERY_STATUS_CHARGING -> "charging"
    BatteryManager.BATTERY_STATUS_DISCHARGING ->"discharge"
    BatteryManager.BATTERY_STATUS_FULL -> "full"
    else-> "I don't know"
    }
                txt.setText(usbMessage)
            }

   }
registerReceiver(receiver, IntentFilter(Intent.ACTION_BATTERY_CHANGED))

    }

    override fun finish() {
    unregisterReceiver(receiver)
    }


}