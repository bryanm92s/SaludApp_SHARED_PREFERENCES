package com.example.saludapp

import android.app.Application

class UserVipApplication:Application(){

    // Para acceder desde otras activities
    companion object{
        // Ésta variable se va a iniciar más tarde lateinit
        lateinit var prefs: Prefs
    }

    // Cuando se cree la clase UserVipApplication hacer lo que este dentro del OnCreate
    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)
    }
}