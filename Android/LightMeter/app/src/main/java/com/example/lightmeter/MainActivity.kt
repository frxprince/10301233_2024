package com.example.lightmeter

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(),SensorEventListener {
    lateinit var txt: TextView
    lateinit var lightSensor:Sensor
    lateinit var manager:SensorManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
     val btn_start= findViewById<Button>(R.id.button); val btn_stop=findViewById<Button>(R.id.button2)
     txt=findViewById(R.id.textView)
     manager=getSystemService(SENSOR_SERVICE) as SensorManager
     lightSensor=manager.getDefaultSensor(Sensor.TYPE_LIGHT) as Sensor
     btn_start.setOnClickListener { manager.registerListener(this,lightSensor,SensorManager.SENSOR_DELAY_NORMAL) }
     btn_stop.setOnClickListener { manager.unregisterListener(this,lightSensor) }
    }
    override fun onSensorChanged(p0: SensorEvent?) {
     txt.text=" ${p0!!.values[0]} LUX  "
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {}
}