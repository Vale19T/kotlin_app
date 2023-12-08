package com.example.myapp_vtc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast


class Consignar : AppCompatActivity() {
    //Variables de tipo privado
    private var rbSaldo:RadioButton?=null
    private var rbConsignar:RadioButton?=null
    private var rbRetirar:RadioButton?=null

    private var textViewSaldo:TextView?=null

    private var editTextNumberConsignar:EditText?=null
    private var editTextNumberRetirar:EditText?=null

    private var saldo = 100.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consignar)

        rbSaldo = findViewById(R.id.rbSaldo)
        rbConsignar = findViewById(R.id.rbConsignar)
        rbRetirar = findViewById(R.id.rbRetirar)

        textViewSaldo = findViewById(R.id.textViewSaldo)

        editTextNumberConsignar = findViewById(R.id.editTextNumberConsignar)
        editTextNumberRetirar = findViewById(R.id.editTextNumberRetirar)
    }
    fun eleccion(view: View){
        //Atributo estatico View.INVISIBLE
        textViewSaldo?.visibility = View.INVISIBLE
        editTextNumberConsignar?.visibility = View.INVISIBLE
        editTextNumberRetirar?.visibility = View.INVISIBLE

        //Crear condiciones segun la opcion que eliga desde los radiobutton el usuario
        if(rbSaldo?.isChecked()==true){
            textViewSaldo?.visibility = View.VISIBLE
            textViewSaldo?.text = "Tu saldo es: $saldo"
        }
        if(rbConsignar?.isChecked()==true){
            editTextNumberConsignar?.visibility = View.VISIBLE
        }
        if(rbRetirar?.isChecked()==true){
            editTextNumberRetirar?.visibility = View.VISIBLE
        }
    }
    fun buttonGuardarConsignar(view:View){
        //Atributo estatico View.VISIBLE
        textViewSaldo?.visibility = View.INVISIBLE
        editTextNumberConsignar?.visibility = View.INVISIBLE
        editTextNumberRetirar?.visibility = View.INVISIBLE

        //Crear condiciones segun la opcion que eliga desde los radiobutton el usuario
        if(rbSaldo?.isChecked()==true){
            textViewSaldo?.text = "Tu saldo es: $saldo"
        }
        if(rbConsignar?.isChecked()==true){
            var Consignar = editTextNumberConsignar?.text.toString().toDouble()
            saldo = saldo + Consignar
            textViewSaldo?.text = "Tu saldo es: $saldo"
            textViewSaldo?.visibility = View.VISIBLE
            Toast.makeText(this, "Tu consignacion fue exitosa!",Toast.LENGTH_LONG).show()
        }
        if(rbRetirar?.isChecked()==true){
            var Retirar = editTextNumberRetirar?.text.toString().toDouble()
            if (saldo-Retirar < 0){
                textViewSaldo?.visibility = View.VISIBLE
                textViewSaldo?.text = "No tienes dinero suficiente!"
            }else{
                saldo = saldo - Retirar
                textViewSaldo?.text = "Tu saldo es: $saldo"
                textViewSaldo?.visibility = View.VISIBLE
                Toast.makeText(this, "Tu consignacion fue exitosa!",Toast.LENGTH_LONG).show()
            }
        }
    }
}