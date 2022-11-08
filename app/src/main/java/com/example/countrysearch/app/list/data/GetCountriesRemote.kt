package com.example.countrysearch.app.list.data

import com.example.countrysearch.app.list.view.adapter.viewmodels.AbstractViewModel

interface GetCountriesRemote {
    suspend fun getCountries(): ArrayList<AbstractViewModel>
}