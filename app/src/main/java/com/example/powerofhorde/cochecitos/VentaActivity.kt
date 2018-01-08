package com.example.powerofhorde.cochecitos

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.molde_coche.*

class VentaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_venta)

        val bundle: Bundle = intent.extras
        val imagen = bundle.getInt("Imagen")
        val titulo = bundle.getString("Titulo")
        val descripcion = bundle.getString("Descripción")
        val precio = bundle.getString("Precio")
        imageView.setImageResource(imagen)
        textViewTitulo.text = titulo
        textViewDescripcion.text = descripcion
        textViewPrecio.text = precio.toString()
    }
}
