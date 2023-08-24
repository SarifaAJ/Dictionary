package com.example.dictionary.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class SubkosaResponse(

	@field:SerializedName("SubkosaResponse")
	val subkosaResponse: List<SubkosaResponseItem>
) : Parcelable {
	constructor(parcel: Parcel) : this(parcel.createTypedArrayList(SubkosaResponseItem)!!) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeTypedList(subkosaResponse)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<SubkosaResponse> {
		override fun createFromParcel(parcel: Parcel): SubkosaResponse {
			return SubkosaResponse(parcel)
		}

		override fun newArray(size: Int): Array<SubkosaResponse?> {
			return arrayOfNulls(size)
		}
	}
}

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

	companion object CREATOR : Parcelable.Creator<SubkosaResponseItem> {
		override fun createFromParcel(parcel: Parcel): SubkosaResponseItem {
			return SubkosaResponseItem(parcel)
		}

		override fun newArray(size: Int): Array<SubkosaResponseItem?> {
			return arrayOfNulls(size)
		}
	}
}
