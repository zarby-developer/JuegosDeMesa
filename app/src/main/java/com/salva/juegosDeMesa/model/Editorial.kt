package com.salva.juegosDeMesa.model

class Editorial {
    var name: String = ""
    var boardGames: ArrayList<JuegosDeMesa> = ArrayList()
    var image: String = ""

    constructor(name: String, image: String) {
        this.name = name
        this.image = image
        DataHolder.allEditorial.add(this)

    }

}