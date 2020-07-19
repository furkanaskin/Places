package com.faskn.persistence.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import com.faskn.data.response.Location
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

/**
 * Created by Furkan on 18.07.2020
 */

@Parcelize
@JsonClass(generateAdapter = true)
@Entity(tableName = "Location")
data class LocationEntity(
    val locationLng: Double? = null,
    val locationLat: Double? = null
) : Parcelable {
    @Ignore
    constructor(location: Location?) : this(
        locationLng = location?.lng,
        locationLat = location?.lat
    )
}
