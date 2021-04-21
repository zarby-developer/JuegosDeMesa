package com.salva.juegosDeMesa.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.salva.juegosDeMesa.R
import com.salva.juegosDeMesa.model.Categorias
import kotlinx.android.synthetic.main.categorias.view.*

class CategoriesAdapter(private val mDataSet: ArrayList<Categorias>?, val categoriesListener : CategoriesListener) : RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.categorias, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = mDataSet?.get(position)
        data?.let {
            holder.bind(it)
            holder.itemView.setOnClickListener {
                categoriesListener.onCategoriesClick(position)
            }

        }
    }
    override fun getItemCount(): Int {
        return mDataSet?.size ?: 0
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Categorias) {

            itemView.nombre.text = item.name




        }


    }
    }
interface CategoriesListener {
    fun onCategoriesClick(position: Int)
}