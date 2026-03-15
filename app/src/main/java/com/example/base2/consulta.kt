package com.example.base2

import android.content.Intent
import android.os.Bundle
import android.view.PixelCopy
import android.view.View
import android.widget.EditText
import android.widget.Toast
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

class consulta : AppCompatActivity(){
var txtFecha: EditText? = null
var txtAsunto: EditText? = null
var txtActividad: EditText? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_consulta)


        txtFecha = findViewById(R.id.txtFecha)
        txtAsunto = findViewById(R.id.txtAsunto)
        txtActividad = findViewById(R.id.txtActividad)
        val Id_agenda=intent.getStringExtra("Id_agenda").toString()

        val queue= Volley.newRequestQueue(this)
        val url = "http://192.168.20.118/android_mysql/consultar.php?Id_agenda=$Id_agenda"
        val jsonObjectRequest= JsonObjectRequest(
            Request.Method.GET,url,null,
            Response.Listener{ response ->

                txtFecha?.setText(response.getString("Fecha"))
                txtAsunto?.setText(response.getString("Asunto"))
                txtActividad?.setText(response.getString("Actividad"))

            },Response.ErrorListener{ error ->
                Toast.makeText(this,error.toString(), Toast.LENGTH_SHORT).show()

        }
        )


        queue.add(jsonObjectRequest)






    }

    fun clickregresar(view: View){

        var intent = Intent(this, MainActivity::class.java)

        startActivity(intent)


    }
}
