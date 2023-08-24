package com.example.dictionary.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class SubbunpoResponse(

	@field:SerializedName("SubbunpoResponse")
	val subbunpoResponse: List<SubbunpoResponseItem>
) : Parcelable {
	constructor(parcel: Parcel) : this(parcel.createTypedArrayList(SubbunpoResponseItem)!!) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeTypedList(subbunpoResponse)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<SubbunpoResponse> {
		override fun createFromParcel(parcel: Parcel): SubbunpoResponse {
			return SubbunpoResponse(parcel)
		}

		override fun newArray(size: Int): Array<SubbunpoResponse?> {
			return arrayOfNulls(size)
		}
	}
}

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
) : Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readString().toString(),
		parcel.readString().toString(),
		parcel.readString().toString(),
		parcel.readString().toString(),
		parcel.readString().toString(),
		parcel.readString().toString()
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(nama)
		parcel.writeString(updatedAt)
		parcel.writeString(idLevel)
		parcel.writeString(createdAt)
		parcel.writeString(id)
		parcel.writeString(createdBy)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<SubbunpoResponseItem> {
		override fun createFromParcel(parcel: Parcel): SubbunpoResponseItem {
			return SubbunpoResponseItem(parcel)
		}

		override fun newArray(size: Int): Array<SubbunpoResponseItem?> {
			return arrayOfNulls(size)
		}
	}
}
