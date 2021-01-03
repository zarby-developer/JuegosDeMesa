package com.salva.juegosDeMesa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.salva.juegosDeMesa.model.DataHolder
import com.salva.juegosDeMesa.model.JuegosDeMesa
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_juego.*



class JuegoActivity : AppCompatActivity() {
lateinit var currentGame : JuegosDeMesa
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)
        currentGame = DataHolder.currentGames[0]
        Picasso.get().load(DataHolder.fondo).into(fondo1)
        Picasso.get().load(DataHolder.currentGames[0].boardGameImage).into(juego)
        titulo.text = DataHolder.currentGames[0].title

        descripcion.text = DataHolder.currentGames[0].description
        DataHolder.currentGames.clear()
    }
}
