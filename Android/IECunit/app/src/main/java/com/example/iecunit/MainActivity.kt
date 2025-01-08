package com.example.iecunit

import android.content.Intent
import android.os.Bundle
import android.renderscript.ScriptGroup.Input
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
    val BtnInputUnit=findViewById<Button>(R.id.button)
 val InputUnitR=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
     result:ActivityResult->
     if(result.resultCode== RESULT_OK){
       Log.v("Result",result.data?.getStringExtra("data")?:"No data")
     }
 }

  BtnInputUnit.setOnClickListener {
   val i= Intent(this,InputUnit::class.java)
   InputUnitR.launch(i)
  }


    }
}