package com.salva.juegosDeMesa.model

class Categorias {
    var name: String = ""
    var boardGames: ArrayList<JuegosDeMesa> = ArrayList()



    constructor(name: String) {
        this.name = name

        DataHolder.allCategories.add(this)

    }
}