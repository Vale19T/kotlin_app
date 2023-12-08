package com.example.myapp_vtc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.StringBuilder

class ListaPendientes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_pendientes)

        val mercado = findViewById<EditText>(R.id.editTextMercado)
        val guardarMercado = findViewById<Button>(R.id.buttonGuardarMercado)

        if (fileList().contains("mercado.txt")){
            try {
                //InputStreamReader leer el archivo
                val archivo = InputStreamReader(openFileInput("mercado.txt"))
                //memoria temporal (BufferedReader) leer el contenido
                val lectura = BufferedReader(archivo)
                var linea = lectura.readLine()
                //almacenar linea por linea
                val contenidoTotal = StringBuilder()

                while (linea != null){
                    contenidoTotal.append(linea +"\n")
                    linea = lectura.readLine()
                }
                lectura.close()
                archivo.close()
                mercado.setText(contenidoTotal)

            }catch (e : IOException){

            }
        }

        guardarMercado.setOnClickListener {
            try {
                val archivo = OutputStreamWriter(openFileOutput("mercado.txt", Activity.MODE_PRIVATE))
                archivo.write(mercado.text.toString())
                //genera la escritura
                archivo.flush()
                archivo.close()
            }catch (e: IOException){

            }
            Toast.makeText(this,"Elemento agregado a la lista", Toast.LENGTH_LONG ).show()
            finish()

        }
    }
}




