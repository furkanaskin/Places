package com.faskn.domain.datasource

import com.faskn.data.response.NearbySearchResponse
import com.faskn.persistence.dao.NearbySearchDao
import com.faskn.persistence.entity.ResultsEntity
import javax.inject.Inject

/**
 * Created by Furkan on 18.07.2020
 */

class NearbySearchLocalDataSource @Inject internal constructor(private val nearbySearchDao: NearbySearchDao) {
    fun nearbySearch() = nearbySearchDao.getNearbyPlaces()

    fun insertNearbySearch(results: NearbySearchResponse) =
        results.results?.map { it?.let { it1 -> ResultsEntity(it1) } }
            ?.let { nearbySearchDao.deleteAndInsert(it) }
}
