package com.faskn.data

import com.faskn.data.response.NearbySearchResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * Created by Furkan on 16.07.2020
 */

interface PlacesAPI {
    @GET("place/nearbysearch/json")
    fun nearbySearch(@QueryMap params: Map<String, String>?): Single<NearbySearchResponse>
}
