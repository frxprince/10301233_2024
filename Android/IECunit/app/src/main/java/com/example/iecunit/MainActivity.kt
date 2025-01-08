package com.example.iecunit

import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.renderscript.ScriptGroup.Input
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

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
    val BtnInputUnit=findViewById<Button>(R.id.button)
    val txtInput=findViewById<EditText>(R.id.editTextNumberDecimal)
    val txtview=findViewById<TextView>(R.id.textView)
    var inBytes=0.0
 val InputUnitR=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
     result:ActivityResult->
     if(result.resultCode== RESULT_OK){
      inBytes= when(result.data?.getStringExtra("data")?:"No data"){
        "kB"->txtInput.text.toString().toDouble()* Math.pow(10.0,3.0)
        "MB"->txtInput.text.toString().toDouble()* Math.pow(10.0,6.0)
        "GB"->txtInput.text.toString().toDouble()* Math.pow(10.0,9.0)
        "TB"->txtInput.text.toString().toDouble()* Math.pow(10.0,12.0)
        else-> 0.0
      }
      txtview.text=DecimalFormat("#,###,###").format(inBytes)+" bytes"
      // Log.v("Result",result.data?.getStringExtra("data")?:"No data")
     }
 }

  BtnInputUnit.setOnClickListener {
   val i= Intent(this,InputUnit::class.java)
   InputUnitR.launch(i)
  }


    }
}