package com.example.videoplayer

import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
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
    val btnInternet=findViewById<Button>(R.id.button2)
    val btnSDCARD=findViewById<Button>(R.id.button3)
    val btnPlay=findViewById<Button>(R.id.button4)
    val btnPause=findViewById<Button>(R.id.button5)
    val btnStop=findViewById<Button>(R.id.button6)
    val wVideoView=findViewById<VideoView>(R.id.videoView)
if(ActivityCompat.checkSelfPermission(this,Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED ){
ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.INTERNET),12124)
}
   btnInternet.setOnClickListener {
       wVideoView.setVideoURI(Uri.parse("http://www.drpaween.com/ohm/cs436/mv.mp4"))
   }
    btnRes.setOnClickListener {
wVideoView.setVideoURI(Uri.parse("android.resource://"+ packageName+"/"+R.raw.video2 ))
    }
btnPlay.setOnClickListener { wVideoView.start() }
btnPause.setOnClickListener { wVideoView.pause() }
btnStop.setOnClickListener { wVideoView.stopPlayback() }

    }
}