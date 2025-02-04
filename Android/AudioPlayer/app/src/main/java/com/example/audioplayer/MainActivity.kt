package com.example.audioplayer

import android.Manifest
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Button
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
        val btnAsset=findViewById<Button>(R.id.button2)
        val btnSDCARD=findViewById<Button>(R.id.button3)
        val btnInternet=findViewById<Button>(R.id.button4)
        val btnPlay=findViewById<Button>(R.id.button5)
        val btnPause=findViewById<Button>(R.id.button6)
        val btnStop=findViewById<Button>(R.id.button7)
    lateinit var Mp:MediaPlayer

if(ActivityCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE)
    != PackageManager.PERMISSION_GRANTED){
 ActivityCompat.requestPermissions(this,
     arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),12321)
}

        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.INTERNET)
            != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.INTERNET),12321)
        }
btnInternet.setOnClickListener {
 Mp=MediaPlayer()
    try {
        Mp.setDataSource(this, Uri.parse("http://112.121.150.133:9000/stream?type=http&nocache=160"))
        Mp.prepare()
    } catch (e: Exception) {
        Mp= MediaPlayer.create(this,R.raw.greeting)
    }
}

btnPause.setOnClickListener { Mp.pause() }
btnStop.setOnClickListener { Mp.stop() }
btnSDCARD.setOnClickListener {
Mp=MediaPlayer()
    Log.v("folder",Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).path)
Mp.setDataSource(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).path
+"/song.mp3")
Mp.prepare()
}
        btnAsset.setOnClickListener {
    var audiofile=assets.openFd("audio/tada.mp3")
            Mp= MediaPlayer()
    Mp.setDataSource(audiofile.fileDescriptor,audiofile.startOffset,audiofile.length)
    Mp.prepare()
        }
        btnRes.setOnClickListener {
        Mp= MediaPlayer() ; Mp= MediaPlayer.create(this,R.raw.greeting)
        }
        btnPlay.setOnClickListener { Mp.start() }
    }
}