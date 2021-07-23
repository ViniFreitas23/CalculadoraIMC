package com.example.calculadoraimc

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btCalcular : Button  = calcular
        val resultado : TextView = resultado
        val btTabela : Button = table

        btTabela.setOnClickListener{
            val intent = Intent(this, tabela::class.java)
            startActivity(intent)
        }

        btCalcular.setOnClickListener{
            val peso: Float = (peso.text.toString()).toFloat()
            val altura:Float = (altura.text.toString()).toFloat()
            val imc:Float = (peso/(altura * altura))

            if (imc < 18.5){
                resultado.setText("Você está abaixo do peso!" + "\n" + "Seu IMC é: " + "%.2f".format(imc))
                resultado.setTextColor(Color.RED)
            } else if (imc > 24.9 && imc < 30){
                resultado.setText("Você está acima do peso!" + "\n" + "Seu IMC é: " + "%.2f".format(imc))
                resultado.setTextColor(Color.RED)
            } else {
                resultado.setText("Seu peso está normal!" + "\n" + "Seu IMC é: " + "%.2f".format(imc))
                resultado.setTextColor(Color.rgb(92, 192, 67))
            }

        }

    }
}