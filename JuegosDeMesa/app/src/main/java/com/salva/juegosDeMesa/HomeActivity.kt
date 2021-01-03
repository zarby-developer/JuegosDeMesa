package com.salva.juegosDeMesa

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.auth.FirebaseAuth
import com.salva.juegosDeMesa.model.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_home.fondo
import kotlinx.android.synthetic.main.activity_juego.*
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.android.synthetic.main.activity_splash.bgg
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

class HomeActivity : AppCompatActivity(), JuegosListener, CategoriesListener, EditorialListener {
    val db = FirebaseAuth.getInstance()
    var TAG = "MiApp"
    var data: ArrayList<JuegosDeMesa> = DataHolder.allGames
    var seleccionado: ArrayList<JuegosDeMesa> = arrayListOf()
    lateinit var currentEditorial : Editorial
    lateinit var currentCategorie : Categorias


    var vehiculo: ArrayList<Editorial> = arrayListOf()
    var vehiculo1: ArrayList<Categorias> = arrayListOf()

    lateinit var adapterR: JuegosAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_home)
        var mAdapter = JuegosAdapter(
            data , this
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
        val filtros = arrayOf("editoriales", "categorias", "todo")
        var checkedItem = 0
        builder.setSingleChoiceItems(
            filtros,
            checkedItem,
            DialogInterface.OnClickListener { dialog, idSeleccionado ->
                Log.v("miapp", "Ha seleccionado $idSeleccionado")
                checkedItem = idSeleccionado


            })

        builder.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
            if (checkedItem == 0){
                vehiculo = DataHolder.allEditorial
              val  mAdapter2 = EditorialAdapter(
                    vehiculo , this
                )
                mainRecicler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                mainRecicler.adapter = mAdapter2

            }else if (checkedItem == 1){
                vehiculo1 = DataHolder.allCategories
                val  mAdapter2 = CategoriesAdapter(
                    vehiculo1 , this
                )
                mainRecicler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                mainRecicler.adapter = mAdapter2
            }else{
                val mAdapter2 = JuegosAdapter(
                    data , this
                )
                mainRecicler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                mainRecicler.adapter = mAdapter2
            }


        })
        builder.setNegativeButton("Cancel", null)
        builder.show()
    }

    override fun onjuegoClick(position: Int) {

            DataHolder.currentGames.add(data[position])



        startActivity(Intent(this, JuegoActivity::class.java))


    }



    override fun onCategoriesClick(position: Int) {
        currentCategorie = vehiculo1[position] as Categorias
        val  mAdapter2 = JuegosAdapter(
           currentCategorie.boardGames, this
        )
        mainRecicler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mainRecicler.adapter = mAdapter2
    }

    override fun onEditorialClick(position: Int) {
        currentEditorial = vehiculo[position] as Editorial
        val  mAdapter2 = JuegosAdapter(
            currentEditorial.boardGames , this
        )
        mainRecicler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mainRecicler.adapter = mAdapter2


    }


}





