package com.salva.juegosDeMesa

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.salva.juegosDeMesa.model.DataHolder
import com.salva.juegosDeMesa.model.JuegosDeMesa
import com.salva.juegosDeMesa.model.Usuario
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.juegos.view.*
import kotlinx.android.synthetic.main.user.view.*

class UsuarioAdapter (
    recyclerOptions: FirestoreRecyclerOptions<Usuario>, var userListener: userListener
) :

    FirestoreRecyclerAdapter<Usuario, UsuarioAdapter.ViewHolder1>(recyclerOptions) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder1 {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user, parent, false)
        return ViewHolder1(view)
    }

    override fun onBindViewHolder(holder: ViewHolder1, position: Int, model: Usuario) {

        holder.bindData(model)
        holder.itemView.setOnClickListener {
            val documentId = model

            userListener.onUserClick(documentId)

        }

    }
    inner class ViewHolder1(view: View) : RecyclerView.ViewHolder(view) {

        fun bindData(item: Usuario) {


            itemView.userName.text = item.name

            Picasso.get().load(DataHolder.icono).into(itemView.icon)
           DataHolder.currentOtherUser.add (item)

            Log.v("miapp", "tarea realizada")

        }


    }


}


interface userListener {
    fun onUserClick(documentId : Usuario)

}