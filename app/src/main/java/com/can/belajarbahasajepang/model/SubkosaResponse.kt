package com.can.belajarbahasajepang.model

import com.google.gson.annotations.SerializedName

data class SubkosaResponse(

	@field:SerializedName("SubkosaResponse")
	val subkosaResponse: List<SubkosaResponseItem>
)

data class SubkosaResponseItem(

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
