package com.example.saludapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import com.example.saludapp.UserVipApplication.Companion.prefs
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
        checkUserValues()
    }

    // Método para comprobar

    fun checkUserValues(){
        // Si el nombre del usuario no es vacío significa que ya lo ingrese en algún momento
        // Está logueado o dentro de la app.
        if (prefs.getName().isNotEmpty()){
            // Si está logueado va directamente al detalle.
            goToDetail()
        }
    }

    // Método para iniciar
    fun initUI(){
        // Capturar el listener del botón
        btnContinuar.setOnClickListener{
            // Pasamos una función
            accesToDetail()
        }
    }

    // Acedemos al detalle
    fun accesToDetail(){
        if (etName.text.toString().isNotEmpty()){
            // Guardamos el usuario
            prefs.saveName(etName.text.toString())
            prefs.saveApellido(etApellido.text.toString())
            prefs.saveEdad(etEdad.text.toString())
            prefs.saveVip(cbVip.isChecked)
            goToDetail()
        }else{
        }
    }
    // Método para ir a otra pantalla
    fun goToDetail(){
        startActivity(Intent(this,ResultActivity::class.java))
    }
}