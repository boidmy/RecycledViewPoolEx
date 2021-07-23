package com.example.recycledviewpoolex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rv_item_second.view.*

class SubAdapterTwo: RecyclerView.Adapter<SubViewHolderSecond>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubViewHolderSecond {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_item_second, parent, false)
        return SubViewHolderSecond(view)
    }

    override fun onBindViewHolder(holder: SubViewHolderSecond, position: Int) {
        holder.bindView(position)
    }

    override fun getItemCount(): Int {
        return 10
    }
}

class SubViewHolderSecond(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val txt = itemView.txt

    fun bindView(index: Int) {
        txt.text = index.toString()
    }
}