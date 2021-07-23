package com.example.recycledviewpoolex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.rv_sub_item.view.*

object Count {
    var count = 0
}

class SubAdapter: RecyclerView.Adapter<SubViewHolder>() {

    var list: List<String> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_sub_item, parent, false)
        println("카운트 = "+Count.count)
        Count.count = Count.count+1
        return SubViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubViewHolder, position: Int) {
        holder.bindView(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData() {
        val arrayList: ArrayList<String> = arrayListOf()
        arrayList.add("하나")
        arrayList.add("둘")
        arrayList.add("셋")
        arrayList.add("넷")
        arrayList.add("다섯")
        arrayList.add("여섯")
        list = arrayList
        notifyDataSetChanged()
    }
}

class SubViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val txt = itemView.txt

    fun bindView(item: String) {
        if (txt.text.isNotEmpty()) {
            txt.text = txt.text
        } else {
            txt.text = item
        }
    }
}
