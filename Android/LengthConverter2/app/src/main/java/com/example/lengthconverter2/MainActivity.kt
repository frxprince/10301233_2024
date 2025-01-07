package com.example.lengthconverter2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
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
    val input=findViewById<EditText>(R.id.editTextNumberDecimal)
    val R1=findViewById<RadioButton>(R.id.radioButton)
    val R2=findViewById<RadioButton>(R.id.radioButton2)
    val Btn=findViewById<Button>(R.id.button)
    val output=findViewById<TextView>(R.id.textView)
   Btn.setOnClickListener {
  var ans = try {
       if(R1.isChecked)input.text.toString().toDouble()/2.54 else
           input.text.toString().toDouble()*2.54
   } catch (e: Exception) {
       0.0
   }
       output.text="$ans"
   }
    }
}