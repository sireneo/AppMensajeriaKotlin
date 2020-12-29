package com.sijc.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val mensaje = txt_msg.text.toString()
            // Creando intent con  acción de envio
            val intent = Intent(Intent.ACTION_SEND)

            // tipo de texto
            intent.type = "text/plain"

            // configuracion del nombre depaquete de whatsapp
            intent.setPackage("com.whatsapp")

            // envio del mensaje
            intent.putExtra(Intent.EXTRA_TEXT, mensaje)

            // Comprobando si whatsapp está instalado o no
            if (intent.resolveActivity(packageManager) == null) {
                Toast.makeText(this,"Por favor instale la aplicacion wasap.",Toast.LENGTH_SHORT).show()
            }

            // iniciando wasap
            startActivity(intent)
        }

    }
}