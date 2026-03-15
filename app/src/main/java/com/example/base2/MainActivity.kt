package com.example.base2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley


class MainActivity : AppCompatActivity() {

    var txtFecha: EditText? = null
    var txtAsunto: EditText? = null
    var txtActividad: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        txtFecha = findViewById<EditText>(R.id.txtFecha)
        txtAsunto = findViewById<EditText>(R.id.txtAsunto)
        txtActividad = findViewById<EditText>(R.id.txtActividad)
        val button = findViewById<Button>(R.id.consultar1)

        button.setOnClickListener {


            // Crear el Intent para ir a la otra Activity
            val intent = Intent(this, Idnumber::class.java)

            // Iniciar la otra Activity
            startActivity(intent)
        }


    }


    fun clickBtnagregar(view: View) {
        val url = "http://192.168.20.118/android_mysql/agregar.php"
        val queue = Volley.newRequestQueue(this)
        var resultadoPost = object : StringRequest(
            Request.Method.POST, url,
            Response.Listener<String> { response ->
                Toast.makeText(this, "Datos registrados", Toast.LENGTH_SHORT).show()

            }, Response.ErrorListener { error ->

                Toast.makeText(this, "Datos no registrados ", Toast.LENGTH_SHORT).show()
            }) {

            override fun getParams(): MutableMap<String, String> {
                val parametros = HashMap<String, String>()
                parametros.put("Fecha", txtFecha?.text.toString())
                parametros.put("Asunto", txtAsunto?.text.toString())
                parametros.put("Actividad", txtActividad?.text.toString())
                return parametros
            }
        }
        queue.add(resultadoPost)

    }

}