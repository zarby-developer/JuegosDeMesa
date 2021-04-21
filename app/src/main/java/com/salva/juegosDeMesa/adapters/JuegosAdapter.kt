package com.salva.juegosDeMesa.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.salva.juegosDeMesa.HomeActivity
import com.salva.juegosDeMesa.R
import com.salva.juegosDeMesa.model.JuegosDeMesa
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.juegos.view.*

class JuegosAdapter(private var mDataSet: ArrayList<JuegosDeMesa>?, private val juegosListener: HomeActivity) : RecyclerView.Adapter<JuegosAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.juegos, parent, false)
            return ViewHolder(view)
        }
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val data = mDataSet?.get(position)
            data?.let {

                holder.bind(it)
                holder.itemView.setOnClickListener { juegosListener.onjuegoClick(position) }


            }
        }

        override fun getItemCount(): Int {
            return mDataSet?.size ?: 0
        }



        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            fun bind(item: JuegosDeMesa) {

                itemView.title.text = item.title

                Picasso.get().load(item.boardGameImage).into(itemView.image)
                itemView.editorial.text = item.editorial!!.name
                itemView.categoria.text = item.categories!!.name
                if(item.numMaxPlayer == item.numMinPlayers){
                    itemView.datos.text = "juego de ${item.numMinPlayers}  jugadores, con una duración aproximada de ${item.duration} minutos"
                }else{
                    itemView.datos.text = "juego de ${item.numMinPlayers} a ${item.numMaxPlayer} jugadores, con una duración aproximada de ${item.duration} minutos"
                }


            }


        }

}
interface JuegosListener {
    fun onjuegoClick(position: Int)


}