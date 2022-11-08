package com.example.countrysearch.app.list.data.remote

import com.example.countrysearch.app.list.data.GetCountriesRemote
import com.example.countrysearch.app.list.view.adapter.entities.Country
import com.example.countrysearch.app.list.view.adapter.viewmodels.AbstractViewModel
import com.example.countrysearch.app.list.view.adapter.viewmodels.CountryViewModel

class CountriesRemoteRepository(private val dataSource: GetCountriesDataSource):
    GetCountriesRemote {
    override suspend fun getCountries(): ArrayList<AbstractViewModel> {
        val result = ArrayList<AbstractViewModel>()
        val countriesFromApi = dataSource.getCountriesFromApi()
        for (countriesResponse in countriesFromApi){
            var capital = ""
            if(countriesResponse.capital.isNotEmpty()){
                capital = countriesResponse.capital[0]
            }
            val country=Country("1",
                countriesResponse.name.official,
                capital,
                countriesResponse.borders,
                countriesResponse.flags.png,
                countriesResponse.region)
            val viewModel = CountryViewModel(country)
            result.add(viewModel)
        }

        return result
    }

}