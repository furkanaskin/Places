package com.faskn.places.dashboard.adapter

import androidx.databinding.ObservableField
import androidx.hilt.lifecycle.ViewModelInject
import com.faskn.core.base.BaseViewModel
import com.faskn.persistence.entity.ResultsEntity

/**
 * Created by Furkan on 16.07.2020
 */

class NearbyPlacesItemViewModel @ViewModelInject internal constructor() : BaseViewModel() {
    val item: ObservableField<ResultsEntity> = ObservableField()
}
