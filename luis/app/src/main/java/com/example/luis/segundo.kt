package com.example.luis

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.startActivity

class segundo : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")

    private lateinit var  volverAUno: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segundo)
        val btnLlamar = findViewById<View>(R.id.btn_llamar)
        btnLlamar.setOnClickListener {
            hacerLlamada()

        }
        }
    }

    //volver a la actividad main
    private fun volverMain() {
        //val intent = Intent(this, MainActivity::class.java)
        //startActivity(intent)


    }
    //hacer llamada
    private fun hacerLlamada() {
        val numeroTelefono = "061"
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$numeroTelefono"))
    }
        /*
        // Verifica si la aplicación tiene permisos para realizar la llamada
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.CALL_PHONE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // Si no hay permiso, solicítalo al usuario
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CALL_PHONE),
                1
            )
        } else {
            // Si hay permiso, realiza la llamada
            startActivity(intent)
        }
    }



    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            // Permiso concedido, realiza la llamada
            hacerLlamada()
        }

    }

         */


