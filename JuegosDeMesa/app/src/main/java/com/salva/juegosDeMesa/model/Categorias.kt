package com.salva.juegosDeMesa.model

class Categorias {
    var name: String = ""
    var boardGames: ArrayList<JuegosDeMesa> = ArrayList()
    var description: String = ""


    constructor(name: String, description: String) {
        this.name = name
        this.description = description
        DataHolder.allCategories.add(this)

    }
}