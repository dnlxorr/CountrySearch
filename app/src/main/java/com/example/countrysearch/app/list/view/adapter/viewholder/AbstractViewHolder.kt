package com.example.countrysearch.app.list.view.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class AbstractViewHolder<in T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var listener: OnItemClickedListener? = null

    abstract fun bind(viewModel: T)

    fun setOnItemClickListener(listener: OnItemClickedListener) {
        this.listener = listener
    }

    interface OnItemClickedListener {
        fun onItemClicked(view: View, adapterPosition: Int)
    }
}
