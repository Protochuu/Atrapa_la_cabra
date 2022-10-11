package com.example.atrapalacabra

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.atrapalacabra.databinding.ActivityMainBinding
class PosicionBoton(var indice: Int,var idtabla: Int,val idboton: Int){

}
class MainActivity : AppCompatActivity() {

    private val botonCerco8 = PosicionBoton(0,R.id.Tabla0,R.id.imageButtoncerco8)
    private val botonCerco1 = PosicionBoton(1,R.id.Tabla0,R.id.imageButtoncerco1)
    private val botonCerco2 = PosicionBoton(2,R.id.Tabla0,R.id.imageButtoncerco2)
    private val botonPasto1 = PosicionBoton(3,R.id.Tabla0,R.id.imageButtonpasto1)
    private val botonCerco7 = PosicionBoton(0,R.id.Tabla1,R.id.imageButtoncerco7)
    private val botonRef = PosicionBoton(1,R.id.Tabla1,R.id.imageButtoninvisible)
    private val botonCerco3 = PosicionBoton(2,R.id.Tabla1,R.id.imageButtoncerco3)
    private val botonCabra = PosicionBoton(3,R.id.Tabla1,R.id.imageButtoncabra)
    private val botonCerco6 = PosicionBoton(0,R.id.Tabla2,R.id.imageButtoncerco6)
    private val botonCerco5 = PosicionBoton(1,R.id.Tabla2,R.id.imageButtoncerco5)
    private val botonCerco4 = PosicionBoton(2,R.id.Tabla2,R.id.imageButtoncerco4)
    private val botonPasto2 = PosicionBoton(3,R.id.Tabla2,R.id.imageButtonpasto2)
    private var botonAnterior : PosicionBoton? = null
    private var botonActual : PosicionBoton? = null
    var numeroDeMovimientos :  Int = 0
//invalidate buscar

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.action_settings -> {
                AlertDialog.Builder(this)
                    .setTitle("Atrapando a la cabra!!!")
                    .setMessage("El objetivo del puzzle es llevar la cabra al centro del cercado en el mínimo número de movimientos.\n" +
                            "Toca los bloques para ir desplazándolos!\n" +
                            "La solución mínima más corta conocida consta de 28 movimientos.\n" +
                            "Aplicación creada por:\n" +
                            "Paula Castillo\n" +
                            "Joaquín Lermanda \n" +
                            "2022 - Desarrollo Aplicaciones Móviles")
                    .setPositiveButton(android.R.string.yes,null)
                    //.setNegativeButton(android.R.string.no, null)
                    .setIcon(android.R.drawable.btn_star_big_on)
                    .show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    fun obtenerPosicionBoton(view: View):PosicionBoton{
        if (view.id==botonCabra.idboton){
            return botonCabra
        }
        else if(view.id==botonRef.idboton){
            return botonRef
        }
        else if(view.id==botonCerco1.idboton){
            return botonCerco1
        }
        else if(view.id==botonCerco2.idboton){
            return botonCerco2
        }
        else if(view.id==botonCerco3.idboton){
            return botonCerco3
        }
        else if(view.id==botonCerco4.idboton){
            return botonCerco4
        }
        else if(view.id==botonCerco5.idboton){
            return botonCerco5
        }
        else if(view.id==botonCerco6.idboton){
            return botonCerco6
        }
        else if(view.id==botonCerco7.idboton){
            return botonCerco7
        }
        else if(view.id==botonCerco8.idboton){
            return botonCerco8
        }
        else if(view.id==botonPasto1.idboton){
            return botonPasto1
        }
        else
            return botonPasto2
    }
    fun condicionesDeInteraccion(view: View){

        if (botonAnterior == null){
            botonAnterior = obtenerPosicionBoton(view)
        }
        else{
            botonActual = obtenerPosicionBoton(view)
            if(botonAnterior == botonActual){
                botonAnterior = null
                return
            }
            if(botonAnterior != botonRef && botonActual != botonRef){
                Log.d("MainActivity",view.toString())
                botonAnterior = null
                return
            }
            val distancia: Int = Math.abs(botonAnterior!!.indice - botonActual!!.indice)
            val cambioTabla = botonAnterior!!.idtabla != botonActual!!.idtabla
            if(distancia > 1){
                botonAnterior = null
                return
            }
            if (cambioTabla && (distancia != 0)){
                botonAnterior = null
                return
            }
            if (cambioTabla){
                val esBotonPasto = (botonAnterior!!.idboton == botonPasto1.idboton)||(botonActual!!.idboton == botonPasto1.idboton)
                val esBotonCerco2 = (botonAnterior!!.idboton == botonCerco2.idboton)||(botonActual!!.idboton == botonCerco2.idboton)
                if(esBotonCerco2 || esBotonPasto ){
                    botonAnterior = null
                    return
                }
                else {
                    movimientoVertical(botonAnterior!!,botonActual!!)
                }
            }
            else
                movimientoHorizontal(botonAnterior!!,botonActual!!)

            numeroDeMovimientos += 1
            findViewById<TextView>(R.id.numeroDeMovimientos).setText("Número de Movimientos: " + numeroDeMovimientos)
            val posicionFinal : Boolean  = revisarJuego()
            revisarEstadoJuego(posicionFinal)
            botonAnterior = null
        }
    }
    fun movimientoHorizontal(posicion1: PosicionBoton, posicion2: PosicionBoton){
        val tabla = findViewById<TableRow>(posicion1.idtabla)
        if (posicion1.idboton == botonCerco2.idboton){
            val botonRef = findViewById<ImageButton>(posicion2.idboton)
            val posicionAnterior = posicion1.indice+1
            tabla.removeView(botonRef)
            tabla.addView(botonRef,posicionAnterior)
            posicion1.indice = posicion2.indice
            posicion2.indice = posicionAnterior
            botonPasto1.indice = posicion2.indice+1
        }
        else if (posicion2.idboton == botonCerco2.idboton){
            val botonRef = findViewById<ImageButton>(posicion1.idboton)
            val posicionAnterior = posicion2.indice+1
            tabla.removeView(botonRef)
            tabla.addView(botonRef,posicionAnterior)
            posicion2.indice = posicion1.indice
            posicion1.indice = posicionAnterior
            botonPasto1.indice = posicion1.indice+1
        }
        else if(posicion1.idboton == botonPasto1.idboton){
            val botonRef = findViewById<ImageButton>(posicion2.idboton)
            val posicionAnterior = posicion2.indice-2
            tabla.removeView(botonRef)
            tabla.addView(botonRef,posicionAnterior)
            posicion1.indice = posicion2.indice
            posicion2.indice = posicionAnterior
            botonCerco2.indice = posicion1.indice-1
        }
        else if(posicion2.idboton == botonPasto1.idboton){
            val botonRef = findViewById<ImageButton>(posicion1.idboton)
            val posicionAnterior = posicion1.indice-2
            tabla.removeView(botonRef)
            tabla.addView(botonRef,posicionAnterior)
            posicion2.indice = posicion1.indice
            posicion1.indice = posicionAnterior
            botonCerco2.indice = posicion2.indice-1
        }
        else{
            val boton = findViewById<ImageButton>(posicion1.idboton)
            val posicionAnterior = posicion1.indice
            tabla.removeView(boton)
            tabla.addView(boton, posicion2.indice)
            posicion1.indice = posicion2.indice
            posicion2.indice = posicionAnterior
        }
    }
    fun movimientoVertical(posicion1: PosicionBoton,posicion2: PosicionBoton){
        val tabla1 = findViewById<TableRow>(posicion1.idtabla)
        val tabla2 = findViewById<TableRow>(posicion2.idtabla)
        val boton1 = findViewById<ImageButton>(posicion1.idboton)
        val boton2 = findViewById<ImageButton>(posicion2.idboton)
        val posicionTabla = posicion1.idtabla
        tabla1.removeView(boton1)
        tabla2.removeView(boton2)
        tabla1.addView(boton2,posicion1.indice)
        tabla2.addView(boton1,posicion2.indice)
        posicion1.idtabla = posicion2.idtabla
        posicion2.idtabla = posicionTabla
    }
    fun revisarEstadoJuego(posicionFinal : Boolean){

        if (posicionFinal){
            if(numeroDeMovimientos == 28){
                val toast =  Toast.makeText(applicationContext,"¡ Has Ganado en el menor número de Movimientos, QUE CRACK !",
                    Toast.LENGTH_SHORT)
                toast.show()
            }
            else{
                val toast =  Toast.makeText(applicationContext,"¡ Has Ganado !", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
    }
    fun revisarJuego(): Boolean {

        if (((botonCerco8.indice != 0) || (botonCerco8.idtabla != R.id.Tabla0))&&((botonCerco4.indice != 0) || (botonCerco4.idtabla != R.id.Tabla0))){
            return false
        }
        if ((botonCerco1.indice != 1) || (botonCerco1.idtabla != R.id.Tabla0)){
            return false
        }
        if ((botonCerco2.indice != 2) || (botonCerco2.idtabla != R.id.Tabla0)){
            return false
        }
        if ((botonPasto1.indice != 3) || (botonPasto1.idtabla != R.id.Tabla0)){
            return false
        }
        if ((botonCerco7.indice != 0) || (botonCerco7.idtabla != R.id.Tabla1)){
            return false
        }
        if ((botonCabra.indice != 1) || (botonCabra.idtabla != R.id.Tabla1)){
            return false
        }
        if ((botonCerco3.indice != 2) || (botonCerco3.idtabla != R.id.Tabla1)){
            return false
        }
        if ((botonRef.indice != 3) || (botonRef.idtabla != R.id.Tabla1)){
            return false
        }
        if ((botonCerco6.indice != 0) || (botonCerco6.idtabla != R.id.Tabla2)){
            return false
        }
        if ((botonCerco5.indice != 1) || (botonCerco5.idtabla != R.id.Tabla2)){
            return false
        }
        if (((botonCerco8.indice != 2) || (botonCerco8.idtabla != R.id.Tabla2))&&((botonCerco4.indice != 2) || (botonCerco4.idtabla != R.id.Tabla2))){
            return false
        }
        if ((botonPasto2.indice != 3) || (botonPasto2.idtabla != R.id.Tabla2)){
            return false
        }
        return true
    }
    fun reset(){
        botonCerco8.indice = 0
        botonCerco8.idtabla = R.id.Tabla0
        botonCerco1.indice = 1
        botonCerco1.idtabla = R.id.Tabla0
        botonCerco2.indice = 2
        botonCerco2.idtabla = R.id.Tabla0
        botonPasto1.indice = 3
        botonPasto1.idtabla = R.id.Tabla0
        botonCerco7.indice = 0
        botonCerco7.idtabla = R.id.Tabla1
        botonRef.indice = 1
        botonRef.idtabla = R.id.Tabla1
        botonCerco3.indice = 2
        botonCerco3.idtabla = R.id.Tabla1
        botonCabra.indice = 3
        botonCabra.idtabla = R.id.Tabla1
        botonCerco6.indice = 0
        botonCerco6.idtabla = R.id.Tabla2
        botonCerco5.indice = 1
        botonCerco5.idtabla = R.id.Tabla2
        botonCerco4.indice = 2
        botonCerco4.idtabla = R.id.Tabla2
        botonPasto2.indice = 3
        botonPasto2.idtabla = R.id.Tabla2
        botonAnterior = null
        botonActual = null
        numeroDeMovimientos = 0
        findViewById<TextView>(R.id.numeroDeMovimientos).setText("Número de Movimientos: " + numeroDeMovimientos)
    }

}