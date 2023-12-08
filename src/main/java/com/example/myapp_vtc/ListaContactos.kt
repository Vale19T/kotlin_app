package com.example.myapp_vtc

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ListaContactos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_contactos)
        val nombre = findViewById<EditText>(R.id.editTextNombre2)
        val datos = findViewById<EditText>(R.id.editTextTextMultiLineDatos)
        val guardar = findViewById<Button>(R.id.buttonGuardar)
        val consultar = findViewById<Button>(R.id.buttonConsultar)
        //Almacenar es un objecto de android
        val preferencias = getSharedPreferences("Agenda", Context.MODE_PRIVATE)

        guardar.setOnClickListener {
            //edit.guardar
            val editor = preferencias.edit()
            editor.putString(nombre.text.toString(), datos.text.toString())
            //para guardar
            editor.commit()
            Toast.makeText(this, "¡Contacto almacenado!", Toast.LENGTH_LONG).show()
            //limpia los datos
            nombre.setText("")
            datos.setText("")
        }

        consultar.setOnClickListener {
            val datosConsultados = preferencias.getString(nombre.text.toString(), "")

            if (datosConsultados !=null){
                if(datosConsultados.length==0){
                    Toast.makeText(this,"¡No existe contacto!", Toast.LENGTH_SHORT ).show()
                }else{
                    datos.setText(datosConsultados)
                }
            }
        }
    }
}


