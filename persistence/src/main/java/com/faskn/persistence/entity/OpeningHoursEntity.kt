package com.faskn.persistence.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import com.faskn.data.response.OpeningHours
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

/**
 * Created by Furkan on 18.07.2020
 */

@Parcelize
@JsonClass(generateAdapter = true)
@Entity(tableName = "OpeningHours")
data class OpeningHoursEntity(
    val openNow: Boolean? = null
) : Parcelable {
    @Ignore
    constructor(openingHours: OpeningHours?) : this(
        openNow = openingHours?.openNow
    )
}
