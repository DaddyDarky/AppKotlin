package com.example.luis

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AlarmaReceiver : BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        // Acción a realizar cuando se activa la alarma
        Toast.makeText(context, "¡Es hora de la alarma!", Toast.LENGTH_SHORT).show()
    }

}
