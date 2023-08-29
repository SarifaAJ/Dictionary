package com.example.dictionary.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class BunpoResponse(

	@field:SerializedName("BunpoResponse")
	val bunpoResponse: List<BunpoResponseItem?>? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(parcel.createTypedArrayList(BunpoResponseItem)) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeTypedList(bunpoResponse)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<BunpoResponse> {
		override fun createFromParcel(parcel: Parcel): BunpoResponse {
			return BunpoResponse(parcel)
		}

		override fun newArray(size: Int): Array<BunpoResponse?> {
			return arrayOfNulls(size)
		}
	}
}

data class BunpoResponseItem(

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("id_sub")
	val idSub: String? = null,

	@field:SerializedName("penjelasan")
	val penjelasan: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("judul")
	val judul: String? = null,

	@field:SerializedName("created_by")
	val createdBy: String? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString()
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(updatedAt)
		parcel.writeString(idSub)
		parcel.writeString(penjelasan)
		parcel.writeString(createdAt)
		parcel.writeString(id)
		parcel.writeString(judul)
		parcel.writeString(createdBy)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<BunpoResponseItem> {
		override fun createFromParcel(parcel: Parcel): BunpoResponseItem {
			return BunpoResponseItem(parcel)
		}

		override fun newArray(size: Int): Array<BunpoResponseItem?> {
			return arrayOfNulls(size)
		}
	}
}
