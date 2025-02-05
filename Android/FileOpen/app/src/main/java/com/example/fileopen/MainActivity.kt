package com.example.fileopen

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    lateinit var txt1: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
  txt1=findViewById(R.id.textView)
if(ActivityCompat.checkSelfPermission(this,Manifest.permission.READ_MEDIA_VIDEO)!=
    PackageManager.PERMISSION_GRANTED)
ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_MEDIA_VIDEO),
    1234)



  val btn=findViewById<Button>(R.id.button)
fun MediaURItoPath(uri: Uri):String{
    var proj=arrayOf(MediaStore.Images.Media.DATA)
    var cursor=contentResolver.query(uri,proj,null,null,null)
    var col_index=cursor?.getColumnIndexOrThrow(MediaStore.Images.Media.DATA) as Int
    cursor.moveToFirst()
    var path=cursor.getString(col_index)
    cursor?.close()
    return path
    }

  val Fileresult=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
      result : ActivityResult->
      if(result.resultCode== RESULT_OK){
          txt1.setText(MediaURItoPath(Uri.parse(result.data?.toURI() )))
      }
  }

      btn.setOnClickListener {
       val i= Intent()
       i.setType("*/*")
       i.setAction(Intent.ACTION_GET_CONTENT)
          Fileresult.launch(Intent.createChooser(i,"Please select the file")  )

      }
    }



}