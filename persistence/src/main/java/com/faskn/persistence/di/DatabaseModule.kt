package com.faskn.persistence.di

import android.app.Application
import androidx.room.Room
import com.faskn.persistence.PlacesDatabase
import com.faskn.persistence.dao.NearbySearchDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 * Created by Furkan on 18.07.2020
 */

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): PlacesDatabase {
        return Room
            .databaseBuilder(application, PlacesDatabase::class.java, "Places.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNearbySearchDao(placesDatabase: PlacesDatabase): NearbySearchDao {
        return placesDatabase.nearbySearchDao()
    }
}
