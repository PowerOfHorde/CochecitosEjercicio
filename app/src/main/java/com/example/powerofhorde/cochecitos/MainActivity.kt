package com.example.powerofhorde.cochecitos

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.molde_coche.view.*

class MainActivity(var adapter: CochesAdapter? = null) : AppCompatActivity() {


    var listaDeCoches = ArrayList<Coche>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listaDeCoches.add(Coche(R.drawable.bowser, "Bowser", "El coche del rival de Mario", "Precio: 1300", false))
        listaDeCoches.add(Coche(R.drawable.camaro, "Camaro", "El coche Camaro edición especial", "Precio: 4550", true))
        listaDeCoches.add(Coche(R.drawable.charger, "Charger", "El famoso charger del 2014", "Precio: 1300", true))
        listaDeCoches.add(Coche(R.drawable.mario, "Super Mario", "El coche del fontanero más famoso del mundo", "Precio: 13040", false))
        listaDeCoches.add(Coche(R.drawable.shark, "Tiburoncito", "Un coche de aspecto amenazante con interior de lujo", "Precio: 1200000", true))
        listaDeCoches.add(Coche(R.drawable.toad, "Toad", "El coche de Toad uno de los ayudantes de Mario", "Precio: 500", false))
        listaDeCoches.add(Coche(R.drawable.woody, "Woody", "El coche del vaquero de Pixar", "Precio: 2100", true))
        listaDeCoches.add(Coche(R.drawable.yoshi, "Yoshi", "El coche del compañero de Mario", "Precio: 7600", false))

        adapter = CochesAdapter(this, listaDeCoches)
        lista.adapter = adapter

    }

    class CochesAdapter(contexto: Context, var listaDeCoches: ArrayList<Coche>) : BaseAdapter() {

        var contexto: Context? = contexto

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val coche = listaDeCoches[p0]
            if (coche.venta == true) {
                val inflater = contexto!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                val mivista = inflater.inflate(R.layout.molde_coche, null)
                mivista.imageView.setImageResource(coche.imagen!!)
                mivista.textViewTitulo.text = coche.titulo!!
                mivista.textViewDescripcion.text = coche.descripcion!!
                mivista.textViewPrecio.text = coche.precio!!.toString()
                mivista.imageView.setOnClickListener {

                    val intent = Intent(contexto, CochesActivity::class.java)
                    intent.putExtra("Imagen", coche.imagen!!)
                    intent.putExtra("Titulo", coche.titulo!!)
                    intent.putExtra("Descripción", coche.descripcion!!)
                    intent.putExtra("Precio", coche.precio!!)
                    contexto!!.startActivity(intent)
                }
                return mivista
            }else{
                val inflater = contexto!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                val mivista = inflater.inflate(R.layout.molde_venta, null)
                mivista.imageView.setImageResource(coche.imagen!!)
                mivista.textViewTitulo.text = coche.titulo!!
                mivista.textViewDescripcion.text = coche.descripcion!!
                mivista.textViewPrecio.text = coche.precio!!.toString()
                mivista.imageView.setOnClickListener {

                    val intent = Intent(contexto, VentaActivity::class.java)
                    intent.putExtra("Imagen", coche.imagen!!)
                    intent.putExtra("Titulo", coche.titulo!!)
                    intent.putExtra("Descripción", coche.descripcion!!)
                    intent.putExtra("Precio", coche.precio!!)
                    contexto!!.startActivity(intent)
                }

                return mivista
            }
        }

        override fun getItem(p0: Int): Any {
            return listaDeCoches[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return listaDeCoches.size
        }


    }
}
