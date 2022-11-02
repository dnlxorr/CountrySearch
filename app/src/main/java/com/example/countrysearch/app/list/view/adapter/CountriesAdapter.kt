package com.example.countrysearch.app.list.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.countrysearch.app.list.view.adapter.factory.CountriesTypeFactory
import com.example.countrysearch.app.list.view.adapter.viewholder.AbstractViewHolder
import com.example.countrysearch.app.list.view.adapter.viewmodels.AbstractViewModel
import kotlin.properties.Delegates

class CountriesAdapter (
    private val typeFactory: CountriesTypeFactory,
    val listener: (AbstractViewModel) -> Unit
) :
    RecyclerView.Adapter<AbstractViewHolder<AbstractViewModel>>(),
     AbstractViewHolder.OnItemClickedListener {

    var items: ArrayList<AbstractViewModel> by Delegates.observable(ArrayList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    lateinit var context: Context

    override fun onBindViewHolder(holder: AbstractViewHolder<AbstractViewModel>, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.setOnItemClickListener(this)

    }

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbstractViewHolder<AbstractViewModel> {
        context = parent.context
        val contactView = LayoutInflater.from(context).inflate(viewType, parent, false)
        return typeFactory.createViewHolder(contactView, viewType) as AbstractViewHolder<AbstractViewModel>
    }

    override fun getItemViewType(position: Int): Int = items[position].type(typeFactory)

    override fun getItemCount() = items.count()


    override fun onItemClicked(view: View, adapterPosition: Int) {
        listener(items[adapterPosition])
    }
}

