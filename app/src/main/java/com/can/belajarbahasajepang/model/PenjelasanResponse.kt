package com.can.belajarbahasajepang.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class PenjelasanResponse(

	@field:SerializedName("PenjelasanResponse")
	val penjelasanResponse: List<PenjelasanResponseItem?>? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(parcel.createTypedArrayList(PenjelasanResponseItem)) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeTypedList(penjelasanResponse)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<PenjelasanResponse> {
		override fun createFromParcel(parcel: Parcel): PenjelasanResponse {
			return PenjelasanResponse(parcel)
		}

		override fun newArray(size: Int): Array<PenjelasanResponse?> {
			return arrayOfNulls(size)
		}
	}
}

data class PenjelasanResponseItem(

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("penjelasan")
	val penjelasan: String? = null,

	@field:SerializedName("id_level")
	val idLevel: String? = null,

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
		parcel.writeString(penjelasan)
		parcel.writeString(idLevel)
		parcel.writeString(createdAt)
		parcel.writeString(id)
		parcel.writeString(judul)
		parcel.writeString(createdBy)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<PenjelasanResponseItem> {
		override fun createFromParcel(parcel: Parcel): PenjelasanResponseItem {
			return PenjelasanResponseItem(parcel)
		}

		override fun newArray(size: Int): Array<PenjelasanResponseItem?> {
			return arrayOfNulls(size)
		}
	}
}
