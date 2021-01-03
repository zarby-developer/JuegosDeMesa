package com.salva.juegosDeMesa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.salva.juegosDeMesa.model.DataHolder
import com.salva.juegosDeMesa.model.JuegosDeMesa
import com.salva.juegosDeMesa.model.Usuario
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_usuarios.*

class UsuariosActivity : AppCompatActivity() , userListener {
    val db = FirebaseFirestore.getInstance()
    var TAG = "MiApp"
    val dc = FirebaseDatabase.getInstance().getReference()
    var data: ArrayList<Usuario> = arrayListOf()
    var auth = FirebaseAuth.getInstance()
    lateinit var adapterR:UsuarioAdapter
    lateinit var fireAdapterUser: FirestoreRecyclerAdapter<Usuario, UsuarioAdapter.ViewHolder1>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuarios)
        title = "Usuarios"
        Picasso.get().load(DataHolder.icono).into(bgg1)
        Picasso.get().load(DataHolder.fondo).into(fondo2)
        val query = db.collection("users")

        val fireOptions =
            FirestoreRecyclerOptions.Builder<Usuario>().setQuery(query, Usuario::class.java).build()

        val mLay = LinearLayoutManager(this)
        mainRecicler3.layoutManager = mLay

        fireAdapterUser = UsuarioAdapter(fireOptions , this )
        mainRecicler3.adapter = fireAdapterUser
        onStart()
    }

    override fun onUserClick(documentId: Usuario) {
      DataHolder.userId = documentId.id.toString()
        DataHolder.nameOtherUser = documentId.name

    Log.d(TAG , "has pulsado a ${DataHolder.userId}")
      startActivity(Intent(this, OtherProfileActivity::class.java))
    }
    override fun onStart() {
        super.onStart()
        fireAdapterUser.startListening()
    }

    override fun onStop() {
        super.onStop()
        fireAdapterUser.stopListening()
    }
}
