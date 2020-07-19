package com.faskn.persistence.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import com.faskn.data.response.PlusCode
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

/**
 * Created by Furkan on 18.07.2020
 */

@Parcelize
@JsonClass(generateAdapter = true)
@Entity(tableName = "PlusCode")
data class PlusCodeEntity(
    val compoundCode: String? = null,
    val globalCode: String? = null
) : Parcelable {
    @Ignore
    constructor(plusCode: PlusCode?) : this(
        compoundCode = plusCode?.compoundCode,
        globalCode = plusCode?.globalCode
    )
}
