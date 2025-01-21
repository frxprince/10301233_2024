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
        overridePendingTransition(R.anim.slide_down,R.anim.slide_down)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    val BtnInputUnit=findViewById<Button>(R.id.button)
    val BtnOutputUnit=findViewById<Button>(R.id.button2)
    val txtInput=findViewById<EditText>(R.id.editTextNumberDecimal)
    val txtview=findViewById<TextView>(R.id.textView)
    var inBytes=0.0
    var outBytes=0.0
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
     }
 }
 val OutputUnitR=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                result:ActivityResult->
            if(result.resultCode== RESULT_OK){
                outBytes= when(result.data?.getStringExtra("data")?:"No data"){
                    "kiB"->inBytes/ Math.pow(2.0,10.0)
                    "MiB"->inBytes/ Math.pow(2.0,20.0)
                    "GiB"->inBytes/ Math.pow(2.0,30.0)
                    "TiB"->inBytes/ Math.pow(2.0,40.0)
                    else-> 0.0
                }
              Log.v("Result",outBytes.toString())
     val i=Intent(this,ShowResult::class.java)
     i.putExtra("data",DecimalFormat("#,###,###").format(outBytes)+
     result.data?.getStringExtra("data")?:"No data" )
     startActivity(i)
            }
        }
BtnOutputUnit.setOnClickListener {val i=Intent(this,OutputUnit::class.java)
OutputUnitR.launch(i)
}
  BtnInputUnit.setOnClickListener {
   val i= Intent(this,InputUnit::class.java)
   InputUnitR.launch(i)
  }


    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_down,R.anim.slide_down)
    }
}