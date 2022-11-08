package com.example.countrysearch.app.list.viewmodel

import androidx.lifecycle.ViewModel
import com.example.countrysearch.app.list.domain.usecase.GetCountries
import com.example.countrysearch.app.list.view.adapter.viewmodels.AbstractViewModel

class CountriesViewModel(private val getCountries: GetCountries) : ViewModel() {

    suspend fun getData(): ArrayList<AbstractViewModel>{
        return getCountries.execute()
    }
}
