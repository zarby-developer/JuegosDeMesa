package com.salva.juegosDeMesa

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.auth.FirebaseAuth
import com.salva.juegosDeMesa.adapters.*
import com.salva.juegosDeMesa.model.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_home.*
import kotlin.collections.ArrayList

class HomeActivity : AppCompatActivity(), JuegosListener, CategoriesListener, EditorialListener {
    val db = FirebaseAuth.getInstance()
    var TAG = "MiApp"
    var data: ArrayList<JuegosDeMesa> = arrayListOf()
    var seleccionado: ArrayList<JuegosDeMesa> = arrayListOf()
    lateinit var currentEditorial : Editorial
    lateinit var currentCategorie : Categorias

    var editoriales:ArrayList<Editorial> = arrayListOf()
    var categorias:ArrayList<Categorias> = arrayListOf()



    lateinit var adapterR: JuegosAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_home)

        title = "Inicio"
        edtSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                filtrar(s.toString())
            }
        })


        data.addAll(DataHolder.allGames.sortedWith(compareBy({ it.title })))
        var mAdapter = JuegosAdapter(
            data, this
        )
        mainRecicler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mainRecicler.adapter = mAdapter
        Picasso.get().load(DataHolder.fondo).into(fondo)


        //  setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.tab_layout_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.perfil -> chat()
            R.id.action_info -> info()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun info() {
        Log.d(TAG, "Info Clicked")
        openChoices()
    }

    private fun chat() {
        Log.d(TAG, "chat Clicked")
// Add a new document with a generated ID
        startActivity(Intent(this, ProfileActivity::class.java))

    }

    private fun openChoices() {
        val builder = MaterialAlertDialogBuilder(this)
        builder.setTitle("filtrar por :")
        val filtros = arrayOf("editoriales", "categorias", "juegos", "usuarios")
        var checkedItem = 0
        builder.setSingleChoiceItems(
            filtros,
            checkedItem,
            DialogInterface.OnClickListener { dialog, idSeleccionado ->
                Log.v("miapp", "Ha seleccionado $idSeleccionado")
                checkedItem = idSeleccionado


            })

        builder.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
            if (checkedItem == 0) {
                editoriales.clear()
               editoriales.addAll(DataHolder.allEditorial.sortedWith(compareBy({ it.name })))
                val mAdapter2 = EditorialAdapter(
                    editoriales, this
                )
                mainRecicler.layoutManager = LinearLayoutManager(
                    this,
                    LinearLayoutManager.VERTICAL,
                    false
                )
                mainRecicler.adapter = mAdapter2

            }
            if (checkedItem == 1) {
                categorias.clear()
                categorias.addAll(DataHolder.allCategories.sortedWith(compareBy({ it.name })))
                val mAdapter2 = CategoriesAdapter(
                    categorias, this
                )
                mainRecicler.layoutManager = LinearLayoutManager(
                    this,
                    LinearLayoutManager.VERTICAL,
                    false
                )
                mainRecicler.adapter = mAdapter2
            }
            if (checkedItem == 2) {
                data.clear()
                data.addAll(DataHolder.allGames.sortedWith(compareBy({ it.title })))
                val mAdapter2 = JuegosAdapter(

                    data, this
                )
                mainRecicler.layoutManager = LinearLayoutManager(
                    this,
                    LinearLayoutManager.VERTICAL,
                    false
                )
                mainRecicler.adapter = mAdapter2
            }
            if(checkedItem== 3){
                startActivity(Intent(this, UsuariosActivity::class.java))

            }


        })
        builder.setNegativeButton("Cancel", null)
        builder.show()
    }

    override fun onjuegoClick(position: Int) {

            DataHolder.currentGames=data[position]
        Log.d(TAG, "he pulsado y el juego es ${data[position].title}")



        startActivity(Intent(this, JuegoActivity::class.java))


    }

    private fun filtrar(toString: String) {
        val listaFiltrada = ArrayList<JuegosDeMesa>()

        for (juego in DataHolder.allGames) {
            if (juego.title.toLowerCase().contains(toString.toLowerCase())) {
                listaFiltrada.add(juego)
                listaFiltrada.sortedWith(compareBy({ it.title}))
                val mAdapter2 = JuegosAdapter(
                    listaFiltrada, this
                )
                mainRecicler.layoutManager = LinearLayoutManager(
                    this,
                    LinearLayoutManager.VERTICAL,
                    false
                )
                data.clear()
                data.addAll(listaFiltrada)
                mainRecicler.adapter = mAdapter2
            }
        }


    }


    override fun onCategoriesClick(position: Int) {
        currentCategorie = categorias[position] as Categorias
        data.clear()
        data.addAll(currentCategorie.boardGames.sortedWith(compareBy({ it.title })))
        val  mAdapter2 = JuegosAdapter(
            data, this
        )
        mainRecicler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mainRecicler.adapter = mAdapter2
    }

    override fun onEditorialClick(position: Int) {
        currentEditorial = editoriales[position] as Editorial
        data.clear()
        data.addAll(currentEditorial.boardGames.sortedWith(compareBy({ it.title })))
        val  mAdapter2 = JuegosAdapter(
            data, this
        )
        mainRecicler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mainRecicler.adapter = mAdapter2


    }






}






