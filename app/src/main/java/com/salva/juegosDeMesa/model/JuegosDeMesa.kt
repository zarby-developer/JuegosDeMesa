package com.salva.juegosDeMesa.model

import org.json.JSONObject

class JuegosDeMesa {

    var title: String = ""
    var boardGameImage: String = ""
    var description: String = ""

    var isfavourite: Boolean = false
    var isWish: Boolean = false
    var editorial: Editorial? = null
    var numMinPlayers: Int = 0
    var numMaxPlayer: Int = 0
    var categories: Categorias? = null
    var duration: Int = 0
    var isMyBoardGame: Boolean = false
    var idYT : String = ""

    constructor(){}
    constructor(
        title: String,
        image: String,
        description: String?,
        editorial: Editorial,
        numMinPlayers: Int,
        numMaxPlayer: Int,
        categorias: Categorias?,
        duration: Int,
        isYT : String
    ) {
        this.title = title
        this.boardGameImage = image
        this.editorial = editorial
        this.description = description!!
        this.numMinPlayers = numMinPlayers
        this.numMaxPlayer = numMaxPlayer
        this.categories = categorias!!
        this.duration = duration
        this.idYT=isYT
        DataHolder.allGames.add(this)


    }

}