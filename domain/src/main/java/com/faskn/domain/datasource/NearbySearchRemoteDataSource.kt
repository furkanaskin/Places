package com.faskn.domain.datasource

import com.faskn.data.PlacesAPI
import javax.inject.Inject

/**
 * Created by Furkan on 18.07.2020
 */

class NearbySearchRemoteDataSource @Inject internal constructor(private val api: PlacesAPI) {

    fun nearbySearch(params: Map<String, String>?) = api.nearbySearch(params)
}
