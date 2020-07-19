package com.faskn.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.faskn.persistence.entity.ResultsEntity

/**
 * Created by Furkan on 18.07.2020
 */

@Dao
interface NearbySearchDao {
    @Query("SELECT * FROM NearbyResults")
    fun getNearbyPlaces(): LiveData<List<ResultsEntity>>

    @Query("SELECT * FROM NearbyResults WHERE id=:id")
    fun getNearbyPlace(id: String): ResultsEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNearbyPlace(results: List<ResultsEntity?>)

    @Transaction
    fun deleteAndInsert(results: List<ResultsEntity?>) {
        deleteAll()
        insertNearbyPlace(results)
    }

    @Update
    fun updateNearbyPlace(results: ResultsEntity)

    @Query("DELETE FROM NearbyResults WHERE id=:id")
    fun deleteNearbyPlace(id: String)

    @Query("DELETE FROM NearbyResults")
    fun deleteAll()

    @Query("Select count(*) from NearbyResults")
    fun getCount(): Int
}
