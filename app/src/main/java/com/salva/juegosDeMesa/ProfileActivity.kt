package com.salva.juegosDeMesa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.salva.juegosDeMesa.adapters.JuegosAdapterProfile
import com.salva.juegosDeMesa.adapters.taskListener
import com.salva.juegosDeMesa.model.DataHolder
import com.salva.juegosDeMesa.model.JuegosDeMesa
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_profile.bgg

class ProfileActivity : AppCompatActivity()  , taskListener {
    val db = FirebaseFirestore.getInstance()
    var TAG = "MiApp"
    var data: ArrayList<JuegosDeMesa> = arrayListOf()
    var auth = FirebaseAuth.getInstance()
    lateinit var adapterR: JuegosAdapterProfile
    lateinit var fireAdapter: FirestoreRecyclerAdapter<JuegosDeMesa, JuegosAdapterProfile.ViewHolder1>
    var ruta = "isfavourite"
    var colec ="favoritos"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        title = "perfil"
        val query = db.collection("users")
            .document(auth.currentUser?.uid.toString())
            .collection(colec).whereEqualTo(ruta, false)
        val fireOptions =
            FirestoreRecyclerOptions.Builder<JuegosDeMesa>().setQuery(query, JuegosDeMesa::class.java).build()

        val mLay = LinearLayoutManager(this)
        mainRecicler2.layoutManager = mLay

        fireAdapter = JuegosAdapterProfile(fireOptions , this )
        mainRecicler2.adapter = fireAdapter
        Log.d(TAG , "deberias poder ver tus favs${auth.currentUser?.uid.toString()}")

        Picasso.get().load(DataHolder.icono).into(bgg)
        Picasso.get().load(DataHolder.fondo).into(fondo1)
        data.addAll(DataHolder.favoritos)

        favourites.setOnClickListener(){
            Log.d(TAG , "Has pulsado favs de ${auth.currentUser?.uid.toString()}")
          ruta = "isfavourite"
            colec = "favoritos"
            val query = db.collection("users")
                .document(auth.currentUser?.uid.toString())
                .collection(colec)
            val fireOptions =
                FirestoreRecyclerOptions.Builder<JuegosDeMesa>().setQuery(query, JuegosDeMesa::class.java).build()

            val mLay = LinearLayoutManager(this)
            mainRecicler2.layoutManager = mLay

            fireAdapter = JuegosAdapterProfile(fireOptions , this )
            mainRecicler2.adapter = fireAdapter
            onStart()
        }

        myGames.setOnClickListener(){
            colec = "mis juegos"
            ruta = "myBoardGame"

           val query = db.collection("users")
                .document(auth.currentUser?.uid.toString())
                .collection("mis juegos")
            val fireOptions =
                FirestoreRecyclerOptions.Builder<JuegosDeMesa>().setQuery(query, JuegosDeMesa::class.java).build()

            val mLay = LinearLayoutManager(this)
            mainRecicler2.layoutManager = mLay

            fireAdapter = JuegosAdapterProfile(fireOptions , this)
            mainRecicler2.adapter = fireAdapter
            onStart()
        }
        myWishes.setOnClickListener(){
            colec = "lista de deseos"
            val query = db.collection("users")
                .document(auth.currentUser?.uid.toString())
                .collection("lista de deseos")
            val fireOptions =
                FirestoreRecyclerOptions.Builder<JuegosDeMesa>().setQuery(query, JuegosDeMesa::class.java).build()

            val mLay = LinearLayoutManager(this)
            mainRecicler2.layoutManager = mLay

            fireAdapter = JuegosAdapterProfile(fireOptions , this)
            mainRecicler2.adapter = fireAdapter
            onStart()
        }


        close.setOnClickListener(){
            FirebaseAuth.getInstance().signOut()
            val goToLogin = Intent(this, MainActivity::class.java)
            startActivity(goToLogin)
            finish()

        }


    }
    override fun onStart() {
        super.onStart()
        fireAdapter.startListening()
    }

    override fun onStop() {
        super.onStop()
        fireAdapter.stopListening()
    }

    override fun onDelete(idDocument: String) {
        db.collection("users")
            .document(auth.currentUser!!.uid)
            .collection(colec)
            .document(idDocument).delete().addOnCompleteListener {
                fireAdapter.notifyDataSetChanged()
            }
        Toast.makeText(
            baseContext, "Removido con éxito", Toast.LENGTH_SHORT
        ).show()
    }


}
