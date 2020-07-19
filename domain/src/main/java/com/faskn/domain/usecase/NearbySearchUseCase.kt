package com.faskn.domain.usecase

import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.faskn.core.utils.UseCaseLiveData
import com.faskn.core.utils.domain.Resource
import com.faskn.domain.paramToMap
import com.faskn.domain.repository.NearbySearchRepository
import com.faskn.domain.viewState.NearbySearchViewState
import com.faskn.persistence.entity.NearbySearchEntity
import com.squareup.moshi.JsonClass
import javax.inject.Inject
import kotlinx.android.parcel.Parcelize

/**
 * Created by Furkan on 16.07.2020
 */

class NearbySearchUseCase @Inject internal constructor(
    private val repository: NearbySearchRepository
) :
    UseCaseLiveData<NearbySearchViewState, UseCaseLiveData.Params, NearbySearchRepository>() {

    override fun buildUseCaseObservable(param: Params?): LiveData<NearbySearchViewState> {
        return repository.nearbySearch(param?.let { paramToMap(it) }).map { onAccountInfoReady(it) }
    }

    private fun onAccountInfoReady(resource: Resource<NearbySearchEntity>): NearbySearchViewState {
        return NearbySearchViewState(
            status = resource.status,
            error = resource.message,
            data = resource.data
        )
    }

    override fun getRepository(): NearbySearchRepository {
        return repository
    }
}

@Parcelize
@JsonClass(generateAdapter = true)
data class NearbyParams(
    val location: String,
    val radius: Int,
    val type: String,
    val key: String
) : Parcelable, UseCaseLiveData.Params()
