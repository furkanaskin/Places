package com.faskn.persistence.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import com.faskn.data.response.Southwest
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

/**
 * Created by Furkan on 18.07.2020
 */

@Parcelize
@JsonClass(generateAdapter = true)
@Entity(tableName = "Southwest")
data class SouthwestEntity(
    val southLng: Double? = null,
    val southLat: Double? = null
) : Parcelable {
    @Ignore
    constructor(southwest: Southwest?) : this(
        southLng = southwest?.lng,
        southLat = southwest?.lat
    )
}
