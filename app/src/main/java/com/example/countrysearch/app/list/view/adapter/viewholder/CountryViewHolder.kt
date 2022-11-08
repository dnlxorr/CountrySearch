package com.example.countrysearch.app.list.view.adapter.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.countrysearch.R
import com.example.countrysearch.app.list.view.adapter.viewmodels.CountryViewModel
import com.squareup.picasso.Picasso

class CountryViewHolder(itemView: View) : AbstractViewHolder<CountryViewModel>(itemView), View.OnClickListener {

    companion object {
        const val LAYOUT: Int = R.layout.country_item_layout
    }

    private val ivFlag: ImageView = itemView.findViewById(R.id.ivFlag)
    private val tvCountryName: TextView = itemView.findViewById(R.id.tvCountryName)
    private val tvCapital: TextView = itemView.findViewById(R.id.tvCapital)

    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        listener?.onItemClicked(v, adapterPosition)
    }

    override fun bind(viewModel: CountryViewModel) {
        Picasso.get().load(viewModel.country.flag).into(ivFlag)
        ivFlag
        tvCountryName.text=viewModel.country.name
        tvCapital.text= viewModel.country.capital
    }

}
