package com.example.helloworld

import android.os.Bundle
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
    Log.e("HelloWorld","The Activity was created")
    //val btn1:Button
    //btn1=findViewById(R.id.button)
    var cx=0
    val btn1 = findViewById<Button>(R.id.button)
        btn1.setOnClickListener {
            cx++;
            btn1.text="HelloWorld $cx"
            Log.e("HelloWorld","Button Clicked $cx")
        }
    val btn2=findViewById<Button>(R.id.buttonExit).setOnClickListener { finish() }
    }

    override fun onStart() {
        super.onStart()
        Log.e("HelloWorld","The Activity was started")
    }

    override fun onResume() {
        super.onResume()
        Log.e("HelloWorld","The Activity was resume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("HelloWorld","The Activity was pause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("HelloWorld","The Activity was stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("HelloWorld","The Activity was destroyed")
    }
}