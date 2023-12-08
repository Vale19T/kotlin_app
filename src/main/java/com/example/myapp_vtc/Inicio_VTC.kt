package com.example.myapp_vtc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Button

class Inicio_VTC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_vtc)

        val usuario = findViewById<EditText>(R.id.editTextUsuario)
        val clave = findViewById<EditText>(R.id.editTextTextPasswordClave)
        val resultado = findViewById<TextView>(R.id.textViewResultado)
        val boton = findViewById<Button>(R.id.buttonIniciar)

        boton.setOnClickListener{
            if (usuario.text.toString().equals("Valeria") && clave.text.toString().equals("1032678527")){
                resultado.setText("Bienvenido ${usuario.text.toString()}")
                val intentos = Intent(this, Menu_LV::class.java)
                startActivity(intentos)
            }else{
                resultado.setText("Datos incorrectos")
            }
        }
    }
}
