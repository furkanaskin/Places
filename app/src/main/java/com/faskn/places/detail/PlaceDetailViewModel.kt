package com.faskn.places.detail

import androidx.databinding.ObservableField
import androidx.hilt.lifecycle.ViewModelInject
import com.faskn.core.base.BaseViewModel
import com.faskn.persistence.dao.NearbySearchDao
import com.faskn.persistence.entity.ResultsEntity
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Furkan on 18.07.2020
 */

class PlaceDetailViewModel @ViewModelInject internal constructor(val nearbySearchDao: NearbySearchDao) :
    BaseViewModel() {
    val item: ObservableField<ResultsEntity> = ObservableField()

    fun updateAsVisited() {
        Observable.create<ResultsEntity> {
            val current = item.get()?.id?.let { nearbySearchDao.getNearbyPlace(it) }
            if (current != null) {
                current.visited = true
                nearbySearchDao.updateNearbyPlace(current)
            }
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

    fun removePlace(): Completable {
        return Completable.fromAction {
            item.get()?.id?.let { it1 -> nearbySearchDao.deleteNearbyPlace(it1) }
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
