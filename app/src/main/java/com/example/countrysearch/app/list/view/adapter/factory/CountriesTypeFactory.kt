package com.example.countrysearch.app.list.view.adapter.factory

import android.view.View
import com.example.countrysearch.app.list.view.adapter.entities.Country
import com.example.countrysearch.app.list.view.adapter.viewholder.AbstractViewHolder

interface CountriesTypeFactory {

    fun type(country: Country): Int

    fun createViewHolder(parent: View, type: Int): AbstractViewHolder<*>
}
