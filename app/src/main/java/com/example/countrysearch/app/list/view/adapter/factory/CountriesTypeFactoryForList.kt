package com.example.countrysearch.app.list.view.adapter.factory

import android.view.View
import com.example.countrysearch.app.list.view.adapter.exception.TypeNotSupportedException
import com.example.countrysearch.app.list.view.adapter.viewholder.AbstractViewHolder
import com.example.countrysearch.app.list.view.adapter.entities.Country
import com.example.countrysearch.app.list.view.adapter.viewholder.CountryViewHolder

class CountriesTypeFactoryForList : CountriesTypeFactory {

    override fun type(country: Country): Int = CountryViewHolder.LAYOUT

    override fun createViewHolder(parent: View, type: Int): AbstractViewHolder<*> {
        return when (type) {
            CountryViewHolder.LAYOUT -> CountryViewHolder(parent)
            else -> throw TypeNotSupportedException.create(String.format("LayoutType: %d", type))
        }
    }
}
