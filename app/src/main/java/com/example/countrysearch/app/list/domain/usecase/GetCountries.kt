package com.example.countrysearch.app.list.domain.usecase

import com.example.countrysearch.app.list.data.GetCountriesRemote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetCountries(private val repository: GetCountriesRemote) {

    suspend fun execute() = withContext(Dispatchers.IO){
        repository.getCountries()
    }
}