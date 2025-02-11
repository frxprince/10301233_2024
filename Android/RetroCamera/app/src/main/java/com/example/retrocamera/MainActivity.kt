package com.example.retrocamera

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
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
    val imageView=findViewById<ImageView>(R.id.imageView)
    val txt=findViewById<EditText>(R.id.editTextText)
    val btn=findViewById<Button>(R.id.button)
    var image: Bitmap?= null
    val rcamera=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result:ActivityResult-> if(result.resultCode== RESULT_OK){
         if(image !=null)image?.recycle()
        image=result.data!!.getParcelableExtra<Bitmap>("data")!!.copy(Bitmap.Config.ARGB_8888,true)
        imageView.setImageBitmap(image)
        }
    }

        imageView.setOnClickListener {
            val i= Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            rcamera.launch(i)
        }



    }
}