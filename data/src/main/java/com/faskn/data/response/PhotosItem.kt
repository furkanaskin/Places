package com.faskn.data.response

import android.os.Parcelable
import androidx.room.Entity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
@Entity(tableName = "PhotosItem")
data class PhotosItem(
    @Json(name = "photo_reference")
    val photoReference: String? = null,
    val width: Int? = null,
    val htmlAttributions: List<String?>? = null,
    val height: Int? = null
) : Parcelable
