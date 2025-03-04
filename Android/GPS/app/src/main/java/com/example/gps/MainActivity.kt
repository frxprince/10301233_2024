package com.example.gps

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(),LocationListener {
  lateinit var txt1:TextView
  lateinit var txt2:TextView
  lateinit var GPS:LocationManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
   txt1=findViewById(R.id.textView);txt2=findViewById(R.id.textView2)
   if(checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED)
   requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),1234)
        if(checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED)
            requestPermissions(arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),1234)
     GPS=getSystemService(LOCATION_SERVICE) as LocationManager

    }

    override fun onResume() {
        super.onResume()
        if(checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED)
          GPS.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,10f,this)
    }

    override fun onPause() {
        super.onPause()
        GPS.removeUpdates(this)
    }

    override fun onLocationChanged(p0: Location) {
      txt1.text="Lat:${p0.latitude} Long:${p0.longitude} Alt:${p0.altitude} \n Clock:${p0.time} Bearing:${p0.bearing}"
    }
}