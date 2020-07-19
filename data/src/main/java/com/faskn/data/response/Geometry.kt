package com.faskn.data.response

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Geometry(
    val viewport: Viewport? = null,
    val location: Location? = null
) : Parcelable
