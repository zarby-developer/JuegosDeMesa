package com.salva.juegosDeMesa

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.salva.juegosDeMesa.model.JuegosDeMesa
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.juegos.view.*






import kotlinx.android.synthetic.main.juegos.view.*
import java.text.SimpleDateFormat
import java.util.*

class JuegosAdapterProfile (
    recyclerOptions: FirestoreRecyclerOptions<JuegosDeMesa>, var taskListener: taskListener
) :

    FirestoreRecyclerAdapter<JuegosDeMesa, JuegosAdapterProfile.ViewHolder1>(recyclerOptions) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder1 {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.juegos, parent, false)
        return ViewHolder1(view)
    }

    override fun onBindViewHolder(holder: ViewHolder1, position: Int, model: JuegosDeMesa) {

        holder.bindData(model)
        holder.itemView.setOnLongClickListener {
            Log.v("miapp", "La pos $position")

            val documentId = snapshots.getSnapshot(position).id
            Log.v("miapp", "La id $documentId")

            taskListener.onDelete(documentId)
            return@setOnLongClickListener true
        }

    }
    inner class ViewHolder1(view: View) : RecyclerView.ViewHolder(view) {

        fun bindData(item: JuegosDeMesa) {


            itemView.title.text = item.title
            itemView.datos.text =
                "juego de ${item.numMinPlayers} a ${item.numMaxPlayer} jugadores, con una duración aproximada de ${item.duration} minutos"
            Picasso.get().load(item.boardGameImage).into(itemView.image)


            Log.v("miapp", "tarea realizada")

        }


    }


}


interface taskListener {
    fun onDelete(idDocument: String)

}

