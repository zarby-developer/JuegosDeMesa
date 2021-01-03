package com.salva.juegosDeMesa.model

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

    constructor(){}
    constructor(
        title: String,
        image: String,
        description: String?,
        editorial: Editorial,
        numMinPlayers: Int,
        numMaxPlayer: Int,
        categorias: Categorias?,
        duration: Int
    ) {
        this.title = title
        this.boardGameImage = image
        this.editorial = editorial
        this.description = description!!
        this.numMinPlayers = numMinPlayers
        this.numMaxPlayer = numMaxPlayer
        this.categories = categorias!!
        this.duration = duration
        DataHolder.allGames.add(this)

    }

}