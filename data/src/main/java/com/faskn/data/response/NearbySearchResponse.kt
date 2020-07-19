package com.faskn.data.response

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class NearbySearchResponse(
    val results: List<ResultsItem?>? = null,
    val status: String? = null
) : Parcelable
