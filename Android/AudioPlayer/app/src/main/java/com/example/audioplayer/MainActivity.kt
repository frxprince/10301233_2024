package com.example.audioplayer

import android.os.Bundle
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
val btnRes=findViewById<Button>(R.id.button)
        val btnAsset=findViewById<Button>(R.id.button2)
        val btnSDCARD=findViewById<Button>(R.id.button3)
        val btnInternet=findViewById<Button>(R.id.button4)
        val btnPlay=findViewById<Button>(R.id.button5)
        val btnPause=findViewById<Button>(R.id.button6)
        val btnStop=findViewById<Button>(R.id.button7)
    }
}