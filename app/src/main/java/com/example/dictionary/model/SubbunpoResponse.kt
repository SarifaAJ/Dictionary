package com.example.dictionary.model

import com.google.gson.annotations.SerializedName

data class SubbunpoResponse(

	@field:SerializedName("SubbunpoResponse")
	val subbunpoResponse: List<SubbunpoResponseItem>
)

data class SubbunpoResponseItem(

	@field:SerializedName("nama")
	val nama: String,

	@field:SerializedName("updated_at")
	val updatedAt: String,

	@field:SerializedName("id_level")
	val idLevel: String,

	@field:SerializedName("created_at")
	val createdAt: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("created_by")
	val createdBy: String
)
