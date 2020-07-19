package com.faskn.persistence.entity

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.faskn.data.response.PhotosItem
import com.faskn.data.response.ResultsItem
import kotlinx.android.parcel.Parcelize

/**
 * Created by Furkan on 18.07.2020
 */

@Parcelize
@Entity(tableName = "NearbyResults")
data class ResultsEntity(
    val types: List<String?>? = null,
    val businessStatus: String? = null,
    val icon: String? = null,
    val rating: Double? = null,
    val reference: String? = null,
    val userRatingsTotal: Int? = null,
    val scope: String? = null,
    val name: String? = null,
    @Embedded
    val geometry: GeometryEntity? = null,
    val vicinity: String? = null,
    @PrimaryKey
    val id: String,
    @Embedded
    val plusCode: PlusCodeEntity? = null,
    val placeId: String? = null,
    val photos: List<PhotosItem?>? = null,
    @Embedded
    val openingHours: OpeningHoursEntity? = null,
    val priceLevel: Int? = null,
    var visited: Boolean? = null
) : Parcelable {

    @Ignore
    constructor(resultsItem: ResultsItem) : this(
        types = resultsItem.types,
        businessStatus = resultsItem.businessStatus,
        icon = resultsItem.icon,
        rating = resultsItem.rating,
        reference = resultsItem.reference,
        userRatingsTotal = resultsItem.userRatingsTotal,
        scope = resultsItem.scope,
        name = resultsItem.name,
        geometry = GeometryEntity(resultsItem.geometry),
        vicinity = resultsItem.vicinity,
        id = resultsItem.id,
        plusCode = PlusCodeEntity(resultsItem.plusCode),
        placeId = resultsItem.placeId,
        photos = resultsItem.photos,
        openingHours = OpeningHoursEntity(resultsItem.openingHours),
        priceLevel = resultsItem.priceLevel
    )

    fun getCoverPhoto(): String? {
        return photos?.first()?.photoReference
    }

    fun getLargestPhoto(): PhotosItem? {
        return photos?.maxBy { it?.width ?: 0 }
    }

    fun getLargestPhotoDimension(): String {
        return "H, ${getLargestPhoto()?.width},${getLargestPhoto()?.height}"
    }

    fun getTotalRatingText(): String {
        return "(${userRatingsTotal ?: 0})"
    }
}
