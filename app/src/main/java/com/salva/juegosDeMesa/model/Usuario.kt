package com.salva.juegosDeMesa.model

class Usuario (){
    var name : String = ""
    var pass : String = ""
   var email : String = ""
    var id : String? = ""
    var myGames : ArrayList<JuegosDeMesa> = arrayListOf()
    var myFavourites : ArrayList<JuegosDeMesa> = arrayListOf()
    var mywhises : ArrayList<JuegosDeMesa> = arrayListOf()
}