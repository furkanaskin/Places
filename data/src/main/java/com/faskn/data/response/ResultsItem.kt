package com.faskn.data.response

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class ResultsItem(
    val types: List<String?>? = null,
    val businessStatus: String? = null,
    val icon: String? = null,
    val rating: Double? = null,
    val reference: String? = null,
    @Json(name = "user_ratings_total")
    val userRatingsTotal: Int? = null,
    val scope: String? = null,
    val name: String? = null,
    val geometry: Geometry? = null,
    val vicinity: String? = null,
    val id: String,
    val plusCode: PlusCode? = null,
    val placeId: String? = null,
    val photos: List<PhotosItem?>? = null,
    val openingHours: OpeningHours? = null,
    val priceLevel: Int? = null
) : Parcelable
