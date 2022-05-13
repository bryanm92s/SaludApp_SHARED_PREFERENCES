package com.example.saludapp

import android.content.Context

class Prefs (val context: Context) {

    val SHARED_NAME="MyDb"
    val SHARED_USER_NAME="username"
    val SHARED_VIP="vip"
    val storage = context.getSharedPreferences(SHARED_NAME,0)

    // Métodos para guardar información

    fun saveName(name:String){
        //Edita nuestra base de datos para añadir un string
        storage.edit().putString(SHARED_USER_NAME, name).apply()
    }

    fun saveVip(vip:Boolean){
        storage.edit().putBoolean(SHARED_VIP, vip).apply()
    }

    // Recuperar información

    fun getName():String{
       return storage.getString(SHARED_USER_NAME,"")!!
    }

    fun getVip():Boolean{
        return  storage.getBoolean(SHARED_VIP,false)
    }

    fun wipe(){
        storage.edit().clear().apply()
    }
}