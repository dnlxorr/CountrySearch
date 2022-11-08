package com.example.countrysearch.core.rest

import com.google.gson.annotations.SerializedName

data class CountriesResponse(

	@field:SerializedName("capital")
	val capital: List<String>,

	@field:SerializedName("borders")
	val borders: List<String>? = null,

	@field:SerializedName("flags")
	val flags: Flags,

	@field:SerializedName("name")
	val name: Name,

	@field:SerializedName("region")
	val region: String

)

data class Name(

	@field:SerializedName("nativeName")
	val nativeName: NativeName? = null,

	@field:SerializedName("common")
	val common: String? = null,

	@field:SerializedName("official")
	val official: String
)

data class Eng(

	@field:SerializedName("common")
	val common: String? = null,

	@field:SerializedName("official")
	val official: String? = null
)

data class NativeName(

	@field:SerializedName("eng")
	val eng: Eng? = null
)

data class Flags(

	@field:SerializedName("svg")
	val svg: String? = null,

	@field:SerializedName("png")
	val png: String
)
