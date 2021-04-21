package com.salva.juegosDeMesa.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.salva.juegosDeMesa.R
import com.salva.juegosDeMesa.model.Editorial
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.editoriales.view.*
import kotlinx.android.synthetic.main.juegos.view.image

class EditorialAdapter (private val mDataSet: ArrayList<Editorial> , val editorialListener: EditorialListener) : RecyclerView.Adapter<EditorialAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.editoriales, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = mDataSet?.get(position)
        data?.let {
            holder.bind(it)
            holder.itemView.setOnClickListener {
            editorialListener.onEditorialClick(position)
            }
        }
    }
    override fun getItemCount(): Int {
        return mDataSet?.size ?: 0
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Editorial) {

           Picasso.get().load(item.image).into(itemView.image)
            itemView.titulo.text = item.name



        }


    }
}
interface EditorialListener {
    fun onEditorialClick(position: Int)
}