package com.faskn.places.splash

import android.content.SharedPreferences
import androidx.databinding.ObservableField
import androidx.hilt.lifecycle.ViewModelInject
import com.faskn.core.base.BaseViewModel
import com.faskn.persistence.dao.NearbySearchDao

/**
 * Created by Furkan on 15.07.2020
 */

class SplashViewModel @ViewModelInject internal constructor(
    private val sharedPreferences: SharedPreferences,
    val nearbyDao: NearbySearchDao
) :
    BaseViewModel() {

    val appName: ObservableField<String> = ObservableField("Places")

    fun saveLocation(lat: String, lon: String) {
        sharedPreferences.edit().putString("lat", lat).apply()
        sharedPreferences.edit().putString("lon", lon).apply()

        updateLocationValues(lat, lon)
    }

    private fun locationChanged(lat: String, lon: String): Boolean {
        return sharedPreferences.getString("lat", lat) != lat &&
            sharedPreferences.getString("lon", lon) != lon
    }

    private fun updateLocationValues(lat: String, lon: String) {
        if (locationChanged(lat, lon))
            nearbyDao.deleteAll()
    }
}
