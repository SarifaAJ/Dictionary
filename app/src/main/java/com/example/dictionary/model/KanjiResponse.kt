package com.example.dictionary.model

import com.google.gson.annotations.SerializedName

data class KanjiResponse(

	@field:SerializedName("KanjiResponse")
	val kanjiResponse: List<KanjiResponseItem>
)

data class KanjiResponseItem(

	@field:SerializedName("onyomi")
	val onyomi: String,

	@field:SerializedName("updated_at")
	val updatedAt: String,

	@field:SerializedName("kanji")
	val kanji: String,

	@field:SerializedName("level_id")
	val levelId: String,

	@field:SerializedName("created_at")
	val createdAt: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("arti")
	val arti: String,

	@field:SerializedName("kunyomi")
	val kunyomi: String
)
