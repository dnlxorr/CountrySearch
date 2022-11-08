package com.example.countrysearch.core.rest

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getCountries(@Url params:String):Response<List<CountriesResponse>>
}