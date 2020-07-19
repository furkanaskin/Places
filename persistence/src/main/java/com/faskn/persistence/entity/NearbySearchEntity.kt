package com.faskn.persistence.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import com.faskn.core.base.Constants
import kotlinx.android.parcel.Parcelize

/**
 * Created by Furkan on 18.07.2020
 */

@Parcelize
@Entity(tableName = "NearbySearch")
data class NearbySearchEntity(
    val results: List<ResultsEntity?>? = null,
    val status: String? = null
) : Parcelable {

    @Ignore
    constructor(results: List<ResultsEntity>) : this(
        results = results,
        status = Constants.StatusCodes.OK
    )
}
