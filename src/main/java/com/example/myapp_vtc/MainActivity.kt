package com.example.myapp_vtc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nombre = findViewById<EditText>(R.id.editTextNombre)
        val botonSaludar = findViewById<Button>(R.id.buttonSaludar)

        botonSaludar.setOnClickListener {
            var recogerNombre = nombre.text.toString()
            Toast.makeText(this,"Welcome $recogerNombre to my App!", Toast.LENGTH_LONG).show()
        }

    }
}
