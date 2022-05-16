package com.example.saludapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.saludapp.UserVipApplication.Companion.prefs
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        initUI()
    }

    fun initUI() {
        btnBack.setOnClickListener {
            prefs.wipe()
            onBackPressed()
        }
        // El nombre del usuario lo tenemos en las preferencias
        val userName = prefs.getName()
        val apellido = prefs.getApellido()
        val edad = prefs.getEdad()

        tvName.text = "Bienvenido $userName"
        tvApellido.text ="Su apellido es: $apellido"
        tvEdad.text="Su edad es: $edad"

        // Si es vip
        if (prefs.getVip()) {
            setVipColorBackground()
        }
    }

        fun setVipColorBackground(){
            // Ponemos un fondo a la vista si el usuario es VIP.
            container.setBackgroundColor(ContextCompat.getColor(this, R.color.vip_yellow))
        }
    }
