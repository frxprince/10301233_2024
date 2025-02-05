package com.example.mypreferences

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
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
    val btnLoad=findViewById<Button>(R.id.button)
   val btnSave=findViewById<Button>(R.id.button2)
   val btnExit=findViewById<Button>(R.id.button3)
        val txt1=findViewById<EditText>(R.id.editTextText)
        val txt2=findViewById<EditText>(R.id.editTextText2)
   btnExit.setOnClickListener { finish() }

   btnSave.setOnClickListener {
       val preferences=getSharedPreferences("MyPrederencedata",Context.MODE_PRIVATE)
       preferences.edit{
           putString("parameter1",txt1.text.toString())
           putString("parameter2",txt2.text.toString())
           commit()
       }
   }
  btnLoad.setOnClickListener {
      val preferences=getSharedPreferences("MyPrederencedata",Context.MODE_PRIVATE)
      txt1.setText(preferences.getString("parameter1","this is the first run"))
      txt2.setText(preferences.getString("parameter2","this is default parameter"))
  }

    }
}