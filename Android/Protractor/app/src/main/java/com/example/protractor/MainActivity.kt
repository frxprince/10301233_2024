package com.example.protractor

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.PI
import kotlin.math.atan2

class MainActivity : AppCompatActivity(),SensorEventListener {
    lateinit var txt1:TextView
    lateinit var txt2:TextView
    lateinit var seekbar:SeekBar
    lateinit var manager:SensorManager
    lateinit var sensor:Sensor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    txt1=findViewById(R.id.textView);txt2=findViewById(R.id.textView2);seekbar=findViewById(R.id.seekBar)
    manager=getSystemService(SENSOR_SERVICE) as SensorManager;sensor=manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) as Sensor
   seekbar.max=180
   seekbar.progressDrawable=getDrawable(R.mipmap.red)
   seekbar.background=getDrawable(R.mipmap.white)
    }
    override fun onResume() {
        manager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL)
        super.onResume()
    }
    override fun onPause() {
        manager.unregisterListener(this,sensor)
        super.onPause()
    }
    override fun onSensorChanged(p0: SensorEvent?) {
     txt1.text="X:${p0!!.values[0]}\nY:${p0!!.values[1]}\nZ:${p0!!.values[2]}"
    var degree=180.0-((atan2(p0.values[0],p0.values[1])*180.0)/ PI)-90.0
    txt2.text="$degree "
   seekbar.progress=  90-degree.toInt()
    }
    override fun onAccuracyChanged(p0: Sensor?, p1: Int){}
}