package com.example.countrysearch.app.list.view.adapter.viewmodels

import com.example.countrysearch.app.list.view.adapter.factory.CountriesTypeFactory

abstract class AbstractViewModel(var id: String? = null) {
    abstract fun type(typeFactory: CountriesTypeFactory): Int

    override fun equals(other: Any?): Boolean {
        if (id == null || other == null) {
            return super.equals(other)
        }

        return (other as AbstractViewModel).id == id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}