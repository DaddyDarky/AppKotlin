package com.example.luis

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.Instrumentation.ActivityResult
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContract
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    //Creamos la referencia al telefono que queremos llamar
    private lateinit var btn_llamada: Button
    companion object {
        const val telefono = "0000000"
    }
    private lateinit var  irSegundo: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            lanzarSegundoActivity()

        //Creamos las referencias a los botones del main, y le daremos utilidad con el setOnClick
            val video= findViewById<Button>(R.id.btn_video)
            video.setOnClickListener{
                abrirVideo()
            }
            val alarma = findViewById<Button>(R.id.btn_alarma)
            alarma.setOnClickListener {
                programarAlarma()
            }

            val personalizado = findViewById<Button>(R.id.btn_perso)
            personalizado.setOnClickListener {
                lanzarSms()
            }




    }

    private fun lanzarSegundoActivity() {
        irSegundo = findViewById<Button>(R.id.btn_llamada)
        irSegundo.setOnClickListener{view ->
            intent= Intent(this,segundo::class.java).apply { putExtra("name","quieres llamar?") }
            startActivity(intent)
        }
    }

    //En esta funcion haremos que nos lleve al app de mensajeria para escribir a alguien
    private fun lanzarSms() {

        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("sms:")
        startActivity(intent)
    }

    //En esta funcion haremos que nos cree una alarma para las 12
    private fun programarAlarma() {

        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, AlarmaReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        // Configurar la hora de la alarma a las 12:00 PM
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, 12)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)

        // Configurar la alarma para que se active a las 12:00 PM
        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY, // Repetir diariamente
            pendingIntent
        )
    }





        //En esta funcion te llevara a un video que cree
        private fun abrirVideo() {
            val url = "https://www.youtube.com/watch?v=_YJjcA20mus"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }


    private fun requestPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            llamada()
        }

    }
}
