package com.salva.juegosDeMesa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.salva.juegosDeMesa.adapters.JuegosAdapterProfile
import com.salva.juegosDeMesa.adapters.taskListener
import com.salva.juegosDeMesa.model.DataHolder
import com.salva.juegosDeMesa.model.JuegosDeMesa
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_other_profile.*

class OtherProfileActivity : AppCompatActivity()  , taskListener {
    val dc = FirebaseDatabase.getInstance().getReference()
    val db = FirebaseFirestore.getInstance()
    var TAG = "MiApp"
    var data: ArrayList<JuegosDeMesa> = arrayListOf()
    var auth = FirebaseAuth.getInstance()
    lateinit var adapterR: JuegosAdapterProfile
     lateinit var UserfireAdapter: FirestoreRecyclerAdapter<JuegosDeMesa, JuegosAdapterProfile.ViewHolder1>
    var ruta = "isfavourite"
    var colec ="favoritos"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other_profile)
        title = DataHolder.nameOtherUser

        val query = db.collection("users")
            .document(DataHolder.userId)
            .collection(colec)
        val fireOptions =
            FirestoreRecyclerOptions.Builder<JuegosDeMesa>().setQuery(query, JuegosDeMesa::class.java).build()

        val mLay = LinearLayoutManager(this)
        mainRecicler4.layoutManager = mLay

        UserfireAdapter = JuegosAdapterProfile(fireOptions , this )
        mainRecicler4.adapter = UserfireAdapter
        Log.d(TAG , "deberias poder ver tus favs${(DataHolder.currentOtherUser)}")

        Picasso.get().load(DataHolder.icono).into(otherbgg)
        Picasso.get().load(DataHolder.fondo).into(otherFondo1)
        data.addAll(DataHolder.favoritos)
        onStart()
        otherFavourites.setOnClickListener(){
            Log.d(TAG , "Has pulsado favs de ${auth.currentUser?.uid.toString()}")
            ruta = "isfavourite"
            colec = "favoritos"
            val query = db.collection("users")
                .document(DataHolder.userId)
                .collection(colec)
            val fireOptions =
                FirestoreRecyclerOptions.Builder<JuegosDeMesa>().setQuery(query, JuegosDeMesa::class.java).build()

            val mLay = LinearLayoutManager(this)
            mainRecicler4.layoutManager = mLay

            UserfireAdapter = JuegosAdapterProfile(fireOptions , this )
            mainRecicler4.adapter = UserfireAdapter
            onStart()
        }
        otherMyGames.setOnClickListener(){
            colec = "mis juegos"
            ruta = "myBoardGame"

            val query = db.collection("users")
                .document(DataHolder.userId)
                .collection("mis juegos")
            val fireOptions =
                FirestoreRecyclerOptions.Builder<JuegosDeMesa>().setQuery(query, JuegosDeMesa::class.java).build()

            val mLay = LinearLayoutManager(this)
            mainRecicler4.layoutManager = mLay

            UserfireAdapter = JuegosAdapterProfile(fireOptions , this)
            mainRecicler4.adapter = UserfireAdapter
            onStart()
        }
        otherWishes.setOnClickListener(){
            colec = "lista de deseos"
            val query = db.collection("users")
                .document(DataHolder.userId)
                .collection("lista de deseos")
            val fireOptions =
                FirestoreRecyclerOptions.Builder<JuegosDeMesa>().setQuery(query, JuegosDeMesa::class.java).build()

            val mLay = LinearLayoutManager(this)
            mainRecicler4.layoutManager = mLay

            UserfireAdapter = JuegosAdapterProfile(fireOptions , this)
            mainRecicler4.adapter =  UserfireAdapter
            onStart()
        }

    }

    override fun onDelete(idDocument: String) {
     Log.d(TAG , "Esta accion no hace nada")
    }
    override fun onStart() {
        super.onStart()
        UserfireAdapter.startListening()
    }

    override fun onStop() {
        super.onStop()
        UserfireAdapter.stopListening()
    }
}
