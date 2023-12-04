package com.example.luis

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.random.Random

class dados : AppCompatActivity() {

    private lateinit var imagen1 :ImageView
    private lateinit var imagen2 :ImageView
    private lateinit var imagen3 :ImageView
    private lateinit var resultado :EditText



    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dados)

        val imageButton= findViewById<Button>(R.id.imageButton)
        val txtResultado= findViewById<Button>(R.id.txt_resultado)
        val dado1 = findViewById<ImageView>(R.id.imagview_dado)
        val dado2 = findViewById<ImageView>(R.id.imagview_dado2)
        val dado3 = findViewById<ImageView>(R.id.imagview_dado3)


        imageButton.setOnClickListener{
            hacerRolls()
        }

    }

    private fun hacerRolls() {
        val random = Random
        val dado1 = random.nextInt(1,7)
        val dado2 = random.nextInt(1,7)
        val dado3 = random.nextInt(1,7)

        val total = dado1 + dado2 + dado3
        val resultText = "Total: $total"

        resultText.also { it -> resultado.text = it }
    }



}