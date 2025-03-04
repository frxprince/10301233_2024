package com.example.textfile

import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.File
import java.io.FileOutputStream

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
   val btnResource=findViewById<Button>(R.id.button)
   val btnAssets=findViewById<Button>(R.id.button2)
   val btnWriteSD=findViewById<Button>(R.id.button3)
   val btnReadSD=findViewById<Button>(R.id.button4)
   val txtFname=findViewById<EditText>(R.id.editTextText)
   val txtData=findViewById<EditText>(R.id.editTextTextMultiLine)


btnReadSD.setOnClickListener {
    val file= File(Environment.getExternalStorageDirectory().absolutePath+"/"+
            Environment.DIRECTORY_DOCUMENTS+"/"+txtFname.text.toString())
    val lines=file.bufferedReader(Charsets.UTF_8).readLines()
    var msg=""
    for(line in lines)
        msg=msg+line+"\n"
    txtData.setText(msg)
}

btnWriteSD.setOnClickListener {
    val file= File(Environment.getExternalStorageDirectory().absolutePath+"/"+
    Environment.DIRECTORY_DOCUMENTS+"/"+txtFname.text.toString())
    val outputfile=FileOutputStream(file)
    outputfile.write(txtData.text.toString().toByteArray())
    outputfile.flush()
    outputfile.close()
}


btnAssets.setOnClickListener {
    val file=assets.open("textfile/pangram.txt")
    val lines=file.bufferedReader(Charsets.UTF_8).readLines()
    var msg=""
    for(line in lines)
        msg=msg+line+"\n"
    txtData.setText(msg)
}

  btnResource.setOnClickListener {
      val file=resources.openRawResource(R.raw.genesis01)
      val lines=file.bufferedReader(Charsets.UTF_8).readLines()
      var msg=""
      for(line in lines)
          msg=msg+line+"\n"
      txtData.setText(msg)
  }



    }
}