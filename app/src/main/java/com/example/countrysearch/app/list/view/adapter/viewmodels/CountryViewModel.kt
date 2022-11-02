package com.example.countrysearch.app.list.view.adapter.viewmodels

import com.example.countrysearch.app.list.view.adapter.entities.Country
import com.example.countrysearch.app.list.view.adapter.factory.CountriesTypeFactory

class CountryViewModel(var country: Country) : AbstractViewModel() {

    init {
        id = country.id
    }

    override fun type(typeFactory: CountriesTypeFactory): Int {
        return typeFactory.type(country)
    }
}
