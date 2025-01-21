package com.example.intent2

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.widget.Button
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
val btnWWW =findViewById<Button>(R.id.button)
val btnMap = findViewById<Button>(R.id.button2)
val btnAlarm= findViewById<Button>(R.id.button3)
btnAlarm.setOnClickListener {
    val i= Intent(AlarmClock.ACTION_SET_TIMER)
    i.putExtra(AlarmClock.EXTRA_LENGTH,10)
    startActivity(i)
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