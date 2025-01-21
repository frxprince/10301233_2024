package com.example.iecunit

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        overridePendingTransition(R.anim.slide_down,R.anim.slide_down)
        setContentView(R.layout.activity_welcome)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

 val Btn=findViewById<ImageButton>(R.id.imageButton)
     Btn.setOnClickListener {
  val intent= Intent(this,MainActivity::class.java)
  startActivity(intent)
     }
   Btn.startAnimation(AnimationUtils.loadAnimation(this,R.anim.rotate))
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_down,R.anim.slide_down)
    }
}