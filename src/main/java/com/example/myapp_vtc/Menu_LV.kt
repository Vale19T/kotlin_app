package com.example.myapp_vtc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

class Menu_LV : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_lv)

        val saludar = findViewById<ImageButton>(R.id.imageButtonSaludar)
        val consignar = findViewById<ImageButton>(R.id.imageButtonConsignar)
        val mercado = findViewById<ImageButton>(R.id.imageButtonPendientes)
        val contacto = findViewById<ImageButton>(R.id.imageButtonContactos)
        val cerrar = findViewById<Button>(R.id.buttonCerrarSesion)

        saludar.setOnClickListener{
            if (saludar == saludar){
                val intentos = Intent(this, MainActivity::class.java)
                startActivity(intentos)
                Toast.makeText(this,"¡Bienvenido a la opción saludar", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Selecciono opción incorrecta", Toast.LENGTH_LONG).show()
            }
        }

        mercado.setOnClickListener{
            if (mercado == mercado){
                val intentos = Intent(this, ListaPendientes::class.java)
                startActivity(intentos)
                Toast.makeText(this,"¡Bienvenido a la opción lista de pendientes", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Selecciono opción incorrecta", Toast.LENGTH_LONG).show()
            }
        }
        contacto.setOnClickListener{
            if (contacto == contacto){
                val intentos = Intent(this, ListaContactos::class.java)
                startActivity(intentos)
                Toast.makeText(this,"¡Bienvenido a la opción lista de contactos", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Selecciono opción incorrecta", Toast.LENGTH_LONG).show()
            }
        }
        consignar.setOnClickListener{
            if (consignar == consignar){
                val intentos = Intent(this, Consignar::class.java)
                startActivity(intentos)
                Toast.makeText(this,"¡Bienvenido a la opción consignar", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Selecciono opción incorrecta", Toast.LENGTH_LONG).show()
            }
        }
    }
}