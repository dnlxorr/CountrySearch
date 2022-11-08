package com.example.countrysearch.app.list.data.remote

import com.example.countrysearch.core.rest.APIService
import com.example.countrysearch.core.rest.CountriesResponse
import com.example.countrysearch.core.rest.RetroInstance

class GetCountriesDataSource {
suspend fun getCountriesFromApi(): List<CountriesResponse> {
    val response = RetroInstance.getRetrofit()
        .create(APIService::class.java).getCountries("?fields=name,capital,flags,borders,region")
        return response.body() ?: emptyList()
    }

}

