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
    lateinit var txt2:TextView
    lateinit var proxSensor:Sensor
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
     txt=findViewById(R.id.textView); txt2=findViewById(R.id.textView2)
     manager=getSystemService(SENSOR_SERVICE) as SensorManager
     lightSensor=manager.getDefaultSensor(Sensor.TYPE_LIGHT) as Sensor
     proxSensor=manager.getDefaultSensor(Sensor.TYPE_PROXIMITY) as Sensor
     btn_start.setOnClickListener {
         manager.registerListener(this,lightSensor,SensorManager.SENSOR_DELAY_NORMAL)
         manager.registerListener(this,proxSensor,SensorManager.SENSOR_DELAY_NORMAL)
     }
     btn_stop.setOnClickListener {
         manager.unregisterListener(this,lightSensor);   manager.unregisterListener(this,proxSensor)
     }
    }
    override fun onSensorChanged(p0: SensorEvent?) {
     if(p0!!.sensor == lightSensor)txt.text=" ${p0!!.values[0]} LUX  "
     if (p0!!.sensor == proxSensor)txt2.text="${p0.values[0]} cm"
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {}
}