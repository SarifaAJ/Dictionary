package com.can.belajarbahasajepang.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class LevelResponse(

	@field:SerializedName("LevelResponse")
	val levelResponse: List<LevelResponseItem>
) : Parcelable {
	constructor(parcel: Parcel) : this(parcel.createTypedArrayList(LevelResponseItem)!!) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeTypedList(levelResponse)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<LevelResponse> {
		override fun createFromParcel(parcel: Parcel): LevelResponse {
			return LevelResponse(parcel)
		}

		override fun newArray(size: Int): Array<LevelResponse?> {
			return arrayOfNulls(size)
		}
	}
}

data class LevelResponseItem(

	@field:SerializedName("nama")
	val nama: String,

	@field:SerializedName("updated_at")
	val updatedAt: String,

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
		parcel.readString().toString()
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(nama)
		parcel.writeString(updatedAt)
		parcel.writeString(createdAt)
		parcel.writeString(id)
		parcel.writeString(createdBy)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<LevelResponseItem> {
		override fun createFromParcel(parcel: Parcel): LevelResponseItem {
			return LevelResponseItem(parcel)
		}

		override fun newArray(size: Int): Array<LevelResponseItem?> {
			return arrayOfNulls(size)
		}
	}
}
