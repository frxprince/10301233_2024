package com.example.lengthconverter

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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
  val input=findViewById<EditText>(R.id.editTextText)
  val btnToCm=findViewById<Button>(R.id.button)
  val btnToInch=findViewById<Button>(R.id.button2)
  val output=findViewById<TextView>(R.id.textView)
  btnToCm.setOnClickListener {
   try {
       output.text=" ${input.text.toString().toFloat()*2.54} cm."
   } catch (e: Exception) {
      output.text= resources.getString(R.string.invalidinput)
   }
  }
    }
}