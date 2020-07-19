package com.faskn.persistence.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import com.faskn.data.response.Northeast
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

/**
 * Created by Furkan on 18.07.2020
 */

@Parcelize
@JsonClass(generateAdapter = true)
@Entity(tableName = "Northeast")
data class NortheastEntity(
    val northLng: Double? = null,
    val northLat: Double? = null
) : Parcelable {
    @Ignore
    constructor(northeast: Northeast?) : this(
        northLng = northeast?.lng,
        northLat = northeast?.lat
    )
}
