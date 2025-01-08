package com.example.iecunit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class InputUnit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_input_unit)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
  val bkB=findViewById<Button>(R.id.bkB)
        val bMB=findViewById<Button>(R.id.bMB)
        val bGB=findViewById<Button>(R.id.bGB)
        val bTB=findViewById<Button>(R.id.bTB)
val i= Intent()
bkB.setOnClickListener { i.putExtra("data","kB");setResult(RESULT_OK,i);finish() }
bGB.setOnClickListener { i.putExtra("data","GB");setResult(RESULT_OK,i);finish() }
bMB.setOnClickListener { i.putExtra("data","MB");setResult(RESULT_OK,i);finish() }
bTB.setOnClickListener { i.putExtra("data","TB");setResult(RESULT_OK,i);finish() }
    }
}