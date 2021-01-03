package com.salva.juegosDeMesa.model

import org.json.JSONObject
import java.util.*
import kotlin.collections.ArrayList

object DataHolder {
    val allGames : ArrayList<JuegosDeMesa> = arrayListOf()
    val allCategories : ArrayList<Categorias> = arrayListOf()
    val allEditorial : ArrayList<Editorial> = arrayListOf()
 var currentGames : JuegosDeMesa = JuegosDeMesa()
    val favoritos : ArrayList<JuegosDeMesa> = arrayListOf()
    val misJuegosDeMesa : ArrayList<JuegosDeMesa> = arrayListOf()
    var currentOtherUser :  ArrayList<Usuario> = arrayListOf()
    var userId : String = ""

    val listaDeDeseos : ArrayList<JuegosDeMesa> = arrayListOf()
    val icono : String = "https://static.cardmarket.com/img/e8d32860b80ab1729e0f10d5601d7c42/public/images/user/avatar/avatar_1996704.png"
    val fondo : String = "https://i.ytimg.com/vi/Ysc3io7HYAc/maxresdefault.jpg"
    var nameOtherUser : String = ""
}