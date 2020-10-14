package com.aim2u.dot_project_aldi_irsanmajid.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseGallery(

	@field:SerializedName("status_code")
	val statusCode: Int? = null,

	@field:SerializedName("placeData")
	val data: List<GalleryData?>? = null,

	@field:SerializedName("message")
	val message: String? = null
) : Parcelable

@Parcelize
data class GalleryData(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("thumbnail")
	val thumbnail: String? = null,

	@field:SerializedName("caption")
	val caption: String? = null
) : Parcelable
