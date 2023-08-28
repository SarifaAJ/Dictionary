package com.example.dictionary.model

import com.google.gson.annotations.SerializedName

data class KosaResponse(

	@field:SerializedName("KosaResponse")
	val kosaResponse: List<KosaResponseItem>
)

data class KosaResponseItem(

	@field:SerializedName("romanji")
	val romanji: String,

	@field:SerializedName("updated_at")
	val updatedAt: String,

	@field:SerializedName("hiragana")
	val hiragana: String,

	@field:SerializedName("id_sub")
	val idSub: String,

	@field:SerializedName("kanji")
	val kanji: String,

	@field:SerializedName("created_at")
	val createdAt: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("arti")
	val arti: String,

	@field:SerializedName("created_by")
	val createdBy: String
)
