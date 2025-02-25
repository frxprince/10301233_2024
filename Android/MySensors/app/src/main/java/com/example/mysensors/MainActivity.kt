package com.example.mysensors

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener,SensorEventListener {
   lateinit var sensor:Sensor
   lateinit var manager:SensorManager
   lateinit var allsensor:MutableList<Sensor>
   lateinit var spinner:Spinner
   lateinit var txt1:TextView
   lateinit var txt2:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        spinner=findViewById(R.id.spinner); txt1=findViewById(R.id.textView);txt2=findViewById(R.id.textView2)
    manager=getSystemService(SENSOR_SERVICE)as SensorManager
    allsensor=manager.getSensorList(Sensor.TYPE_ALL)
    var sensorname= mutableListOf<String>()
    for(name in allsensor)sensorname.add(name.name)
    var adapter=ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,sensorname)
    spinner.adapter=adapter
    spinner.onItemSelectedListener=this
    sensor=allsensor[0]
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        if(sensor!=null)manager.unregisterListener(this,sensor)
     sensor=allsensor[p2]
     txt1.text="Name:${sensor.name}\nVender:${sensor.vendor}\nVersion:${sensor.version}\nMax:${sensor.maximumRange}" +
             "\nResolution:${sensor.resolution}     "

        manager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL)
    }
    override fun onSensorChanged(p0: SensorEvent?) {
var msg:String=""
for((index,item) in p0!!.values.withIndex()){msg+="Parameter[$index]=$item\n"  }
        txt2.text=msg
    }
    override fun onNothingSelected(p0: AdapterView<*>?) {

    }



    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }
}