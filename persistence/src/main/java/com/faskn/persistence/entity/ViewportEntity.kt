package com.faskn.persistence.entity

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import com.faskn.data.response.Viewport
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

/**
 * Created by Furkan on 18.07.2020
 */

@Parcelize
@JsonClass(generateAdapter = true)
@Entity(tableName = "Viewport")
data class ViewportEntity(
    @Embedded
    val southwest: SouthwestEntity? = null,
    @Embedded
    val northeast: NortheastEntity? = null
) : Parcelable {
    @Ignore
    constructor(viewport: Viewport?) : this(
        southwest = SouthwestEntity(viewport?.southwest),
        northeast = NortheastEntity(viewport?.northeast)
    )
}
