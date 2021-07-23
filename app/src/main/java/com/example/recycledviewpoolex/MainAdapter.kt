package com.example.recycledviewpoolex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rv_item.view.*

class MainAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val viewPool: RecyclerView.RecycledViewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 1) {
            val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.rv_item, parent, false)
            MainViewHolderTwo(view)
        } else {
            val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.rv_item, parent, false)
            MainViewHolder(view, viewPool)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MainViewHolderTwo) {

        } else if (holder is MainViewHolder) {
            holder.bindView()
        }
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 1) {
            1
        } else {
            0
        }
    }
}

class MainViewHolder(itemView: View, viewPool: RecyclerView.RecycledViewPool): RecyclerView.ViewHolder(
    itemView
) {
    private val subRv = itemView.subRv
    private val adapter = SubAdapter()

    init {
        subRv.adapter = adapter
        val layoutManager = LinearLayoutManager(itemView.context)
        layoutManager.recycleChildrenOnDetach = true
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        subRv.layoutManager = layoutManager
        subRv.setRecycledViewPool(viewPool)
    }

    fun bindView() {
        adapter.setData()
    }
}

class MainViewHolderTwo(itemView: View): RecyclerView.ViewHolder(
    itemView
) {
    private val subRv = itemView.subRv
    private val adapter = SubAdapterTwo()

    init {
        subRv.adapter = adapter
        val layoutManager = LinearLayoutManager(itemView.context)
        layoutManager.recycleChildrenOnDetach = true
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        subRv.layoutManager = layoutManager
    }
}
