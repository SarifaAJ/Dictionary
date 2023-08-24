package com.example.dictionary.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class KosaResponse(

	@field:SerializedName("KosaResponse")
	val kosaResponse: List<KosaResponseItem>
) : Parcelable {
	constructor(parcel: Parcel) : this(parcel.createTypedArrayList(KosaResponseItem)!!) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeTypedList(kosaResponse)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<KosaResponse> {
		override fun createFromParcel(parcel: Parcel): KosaResponse {
			return KosaResponse(parcel)
		}

		override fun newArray(size: Int): Array<KosaResponse?> {
			return arrayOfNulls(size)
		}
	}
}

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
) : Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readString().toString(),
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
		parcel.writeString(romanji)
		parcel.writeString(updatedAt)
		parcel.writeString(hiragana)
		parcel.writeString(idSub)
		parcel.writeString(kanji)
		parcel.writeString(createdAt)
		parcel.writeString(id)
		parcel.writeString(arti)
		parcel.writeString(createdBy)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<KosaResponseItem> {
		override fun createFromParcel(parcel: Parcel): KosaResponseItem {
			return KosaResponseItem(parcel)
		}

		override fun newArray(size: Int): Array<KosaResponseItem?> {
			return arrayOfNulls(size)
		}
	}
}
