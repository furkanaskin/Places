package com.faskn.places.main

import androidx.databinding.ObservableField
import androidx.hilt.lifecycle.ViewModelInject
import com.faskn.core.base.BaseViewModel
import com.faskn.places.BuildConfig

/**
 * Created by Furkan on 15.07.2020
 */

class MainViewModel @ViewModelInject internal constructor() : BaseViewModel() {
    var testText: ObservableField<String> =
        ObservableField(BuildConfig.VERSION_NAME + BuildConfig.VERSION_CODE)
}
