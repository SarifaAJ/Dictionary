package com.example.dictionary.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class KanjiResponse(

	@field:SerializedName("KanjiResponse")
	val kanjiResponse: List<KanjiResponseItem>
) : Parcelable {
	constructor(parcel: Parcel) : this(parcel.createTypedArrayList(KanjiResponseItem)!!) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeTypedList(kanjiResponse)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<KanjiResponse> {
		override fun createFromParcel(parcel: Parcel): KanjiResponse {
			return KanjiResponse(parcel)
		}

		override fun newArray(size: Int): Array<KanjiResponse?> {
			return arrayOfNulls(size)
		}
	}
}

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
) : Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readString().toString(),
		parcel.readString().toString(),
		parcel.readString().toString(),
		parcel.readString().toString(),
		parcel.readString().toString(),
		parcel.readString().toString(),
		parcel.readString().toString(),
		parcel.readString().toString()
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(onyomi)
		parcel.writeString(updatedAt)
		parcel.writeString(kanji)
		parcel.writeString(levelId)
		parcel.writeString(createdAt)
		parcel.writeString(id)
		parcel.writeString(arti)
		parcel.writeString(kunyomi)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<KanjiResponseItem> {
		override fun createFromParcel(parcel: Parcel): KanjiResponseItem {
			return KanjiResponseItem(parcel)
		}

		override fun newArray(size: Int): Array<KanjiResponseItem?> {
			return arrayOfNulls(size)
		}
	}
}
