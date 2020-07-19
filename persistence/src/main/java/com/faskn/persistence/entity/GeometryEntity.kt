package com.faskn.persistence.entity

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import com.faskn.data.response.Geometry
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

/**
 * Created by Furkan on 18.07.2020
 */

@Parcelize
@JsonClass(generateAdapter = true)
@Entity(tableName = "Geometry")
data class GeometryEntity(
    @Embedded
    val viewport: ViewportEntity? = null,
    @Embedded
    val location: LocationEntity? = null
) : Parcelable {

    @Ignore
    constructor(geometry: Geometry?) : this(
        viewport = ViewportEntity(geometry?.viewport),
        location = LocationEntity(geometry?.location)
    )
}
