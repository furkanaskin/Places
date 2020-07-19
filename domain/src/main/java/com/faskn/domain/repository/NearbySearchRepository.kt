package com.faskn.domain.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.faskn.core.base.Constants
import com.faskn.core.utils.domain.RateLimiter
import com.faskn.core.utils.domain.Resource
import com.faskn.data.response.NearbySearchResponse
import com.faskn.domain.NetworkBoundResource
import com.faskn.domain.datasource.NearbySearchLocalDataSource
import com.faskn.domain.datasource.NearbySearchRemoteDataSource
import com.faskn.persistence.entity.NearbySearchEntity
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by Furkan on 16.07.2020
 */

class NearbySearchRepository @Inject constructor(
    private val localDataSource: NearbySearchLocalDataSource,
    private val remoteDataSource: NearbySearchRemoteDataSource
) {
    private val nearbySearchRateLimit = RateLimiter<String>(30, TimeUnit.SECONDS)

    fun nearbySearch(
        params: Map<String, String>?
    ): LiveData<Resource<NearbySearchEntity>> {
        return object : NetworkBoundResource<NearbySearchEntity, NearbySearchResponse>() {
            override fun saveCallResult(item: NearbySearchResponse) {
                localDataSource.insertNearbySearch(item)
            }

            override fun loadFromDb(): LiveData<NearbySearchEntity> {
                return localDataSource.nearbySearch().map {
                    NearbySearchEntity(it)
                }
            }

            override fun createCall(): Single<NearbySearchResponse> =
                remoteDataSource.nearbySearch(params)

            override fun onFetchFailed() {
                nearbySearchRateLimit.reset(Constants.NetworkService.RATE_LIMITER_TYPE)
            }

            override fun shouldFetch(data: NearbySearchEntity?): Boolean {
                return data?.results.isNullOrEmpty()
            }
        }.asLiveData
    }
}
