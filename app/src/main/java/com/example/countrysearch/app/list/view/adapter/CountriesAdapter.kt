package com.example.countrysearch.app.list.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import androidx.recyclerview.widget.RecyclerView
import com.example.countrysearch.app.list.view.adapter.factory.CountriesTypeFactoryForList
import com.example.countrysearch.app.list.view.adapter.viewholder.AbstractViewHolder
import com.example.countrysearch.app.list.view.adapter.viewmodels.AbstractViewModel
import com.example.countrysearch.app.list.view.adapter.viewmodels.CountryViewModel

class CountriesAdapter (
    val listener: (AbstractViewModel) -> Unit
) :
    RecyclerView.Adapter<AbstractViewHolder<AbstractViewModel>>(),
     AbstractViewHolder.OnItemClickedListener{

    private val typeFactory = CountriesTypeFactoryForList()
    private var originalItems: MutableList<AbstractViewModel>? = null
    private lateinit var items: ArrayList<AbstractViewModel>
    private lateinit var context: Context

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

    fun filterCountries(): Filter {
        return object : Filter() {
            override fun performFiltering(p0: CharSequence): FilterResults {
                items.clear()
                val filteredItems = originalItems?.filter { model ->
                    (model as CountryViewModel).country.name.contains(p0, true) ||
                            model.country.capital.contains(p0, true)
                 }?.toMutableList()

                val results = FilterResults()
                results.values = filteredItems
                return results
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                p1?.let {
                    items = it.values as ArrayList<AbstractViewModel>
                    notifyDataSetChanged()
                }
            }
        }
    }

    fun addItems(data: ArrayList<AbstractViewModel>) {
        items = data
        originalItems = data.toMutableList()
        notifyDataSetChanged()
    }
}

