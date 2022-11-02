package com.example.countrysearch.app.list.view.adapter.viewholder

import android.view.View
import com.example.countrysearch.R
import com.example.countrysearch.app.list.view.adapter.viewmodels.CountryViewModel

class CountryViewHolder(itemView: View) : AbstractViewHolder<CountryViewModel>(itemView), View.OnClickListener {

    companion object {
        const val LAYOUT: Int = R.layout.country_item_layout
    }

    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        listener?.onItemClicked(v, adapterPosition)
    }

    override fun bind(viewModel: CountryViewModel) {

    }

    interface OnItemClickedListener {
        fun onItemClicked(view: View, adapterPosition: Int)
    }
}
