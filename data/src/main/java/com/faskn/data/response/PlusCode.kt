package com.faskn.data.response

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class PlusCode(
    val compoundCode: String? = null,
    val globalCode: String? = null
) : Parcelable
