package com.example.iecunit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OutputUnit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_output_unit)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    val i = Intent()
    val bkiB=findViewById<Button>(R.id.bkiB)
        val bMiB=findViewById<Button>(R.id.bMiB)
        val bGiB=findViewById<Button>(R.id.bGiB)
        val bTiB=findViewById<Button>(R.id.bTiB)
bkiB.setOnClickListener {i.putExtra("data","kiB");setResult(RESULT_OK,i);finish()  }
bMiB.setOnClickListener {i.putExtra("data","MiB");setResult(RESULT_OK,i);finish()  }
bGiB.setOnClickListener {i.putExtra("data","GiB");setResult(RESULT_OK,i);finish()  }
bTiB.setOnClickListener {i.putExtra("data","TiB");setResult(RESULT_OK,i);finish()  }
    }
}