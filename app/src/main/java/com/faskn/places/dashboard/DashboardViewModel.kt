package com.faskn.places.dashboard

import android.content.SharedPreferences
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.faskn.core.base.BaseViewModel
import com.faskn.core.base.Constants
import com.faskn.domain.usecase.NearbyParams
import com.faskn.domain.usecase.NearbySearchUseCase
import com.faskn.domain.viewState.NearbySearchViewState

/**
 * Created by Furkan on 16.07.2020
 */

class DashboardViewModel @ViewModelInject internal constructor(
    private val sharedPreferences: SharedPreferences,
    private val useCase: NearbySearchUseCase
) : BaseViewModel() {

    private val _nearbyPlacesParams: MutableLiveData<NearbyParams> = MutableLiveData()
    private val _nearbyPlacesViewState: LiveData<NearbySearchViewState> =
        _nearbyPlacesParams.switchMap { params ->
            useCase.execute(params)
        }

    val nearbyPlacesViewState: LiveData<NearbySearchViewState> = _nearbyPlacesViewState

    fun setParams() {
        if (_nearbyPlacesParams.value == null) {
            val lat = sharedPreferences.getString(Constants.Coordinates.LAT, "") ?: ""
            val lon = sharedPreferences.getString(Constants.Coordinates.LON, "") ?: ""

            val param = NearbyParams(
                location = "$lat,$lon",
                radius = 1000,
                type = Constants.PlaceTypes.PLACE_TYPE_RESTAURANT,
                key = Constants.NetworkService.API_KEY
            )
            _nearbyPlacesParams.postValue(param)
        }
    }
}
