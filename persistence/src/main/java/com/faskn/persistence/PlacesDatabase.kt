package com.faskn.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.faskn.persistence.converters.DataConverters
import com.faskn.persistence.dao.NearbySearchDao
import com.faskn.persistence.entity.ResultsEntity

/**
 * Created by Furkan on 18.07.2020
 */

@Database(
    entities = [
        ResultsEntity::class
    ],
    version = 1,
    exportSchema = true
)

@TypeConverters(DataConverters::class)

abstract class PlacesDatabase : RoomDatabase() {

    abstract fun nearbySearchDao(): NearbySearchDao
}
