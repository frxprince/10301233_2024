package com.example.intent2

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.ContactsContract
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
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
val btnWWW =findViewById<Button>(R.id.button)
val btnMap = findViewById<Button>(R.id.button2)
val btnAlarm= findViewById<Button>(R.id.button3)
val btnContact=findViewById<Button>(R.id.button4)
val btnCamera=findViewById<Button>(R.id.button5)
btnCamera.setOnClickListener {
    val i= Intent(MediaStore.ACTION_PICK_IMAGES)
    startActivity(i)
}
btnContact.setOnClickListener {
    val i= Intent(Intent.ACTION_PICK)
    i.type= ContactsContract.Contacts.CONTENT_TYPE
    startActivity(i)
}

 if( ContextCompat.checkSelfPermission(this,"com.android.alarm.permission.SET_ALARM")!=
     PackageManager.PERMISSION_GRANTED)
 {
  ActivityCompat.requestPermissions(this, arrayOf("com.android.alarm.permission.SET_ALARM"),
      1234)
 }else {
     btnAlarm.setOnClickListener {
         val i = Intent(AlarmClock.ACTION_SET_TIMER).apply {
             putExtra(AlarmClock.EXTRA_MESSAGE,"Hello World")
             putExtra(AlarmClock.EXTRA_SKIP_UI,true)
             putExtra(AlarmClock.EXTRA_LENGTH, 10)
         }
         startActivity(i)
     }
 }




btnWWW.setOnClickListener {
val i= Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mju.ac.th"))
 startActivity(i)

}
btnMap.setOnClickListener {
    val i= Intent(Intent.ACTION_VIEW, Uri.parse("geo:18.9404979,99.1175137"))
    startActivity(i)
}
    }
}