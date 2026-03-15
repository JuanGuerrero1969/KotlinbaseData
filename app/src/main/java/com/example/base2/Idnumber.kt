package com.example.base2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Idnumber : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_idnumber)




    }

    fun clickVer(view: View){
        var txtId=findViewById<EditText>(R.id.txtID)
        var intent = Intent(this, consulta::class.java)
        intent.putExtra("Id_agenda",txtId.text.toString())
        startActivity(intent)

    }
}