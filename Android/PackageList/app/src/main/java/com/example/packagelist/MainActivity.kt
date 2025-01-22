package com.example.packagelist

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
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
        val txt1=findViewById<TextView>(R.id.textView)
        val txt2=findViewById<TextView>(R.id.textView2)
        val btn=findViewById<Button>(R.id.button)
        val listview=findViewById<ListView>(R.id.listview1)
 var displayList= mutableListOf<String>()
var packagelist=packageManager.getInstalledApplications(PackageManager.GET_META_DATA)
 for(item in packagelist){
     displayList.add(item.packageName)
     Log.v("my package",item.packageName)
 }
val adp=ArrayAdapter(this,R.layout.activity_listviewitem,displayList.toTypedArray())
listview.adapter=adp
listview.setOnItemClickListener { adapterView: AdapterView<*>, view: View, i:Int, l:Long ->
 txt1.text=listview.getItemAtPosition(i).toString()
if(packageManager.getLaunchIntentForPackage(txt1.text.toString()) !=null){
 btn.isEnabled=true
txt2.text=  packageManager.getLaunchIntentForPackage(txt1.text.toString()).toString()
}else{ btn.isEnabled=false;txt2.text="can not launch" }
}
btn.setOnClickListener {
startActivity(packageManager.getLaunchIntentForPackage(txt1.text.toString()))
}
    }
}