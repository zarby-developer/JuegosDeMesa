package com.salva.juegosDeMesa.model

import java.util.*
import kotlin.collections.ArrayList

object DataHolder {
    val allGames : ArrayList<JuegosDeMesa> = arrayListOf()
    val allCategories : ArrayList<Categorias> = arrayListOf()
    val allEditorial : ArrayList<Editorial> = arrayListOf()
 var currentGames : ArrayList<JuegosDeMesa> = arrayListOf()
    val icono : String = "https://megahaulin.files.wordpress.com/2015/09/geek_head.jpg"
    val fondo : String = "https://donmeeple.com/wp-content/uploads/2020/04/bgg-board-game-geek.jpg"
}