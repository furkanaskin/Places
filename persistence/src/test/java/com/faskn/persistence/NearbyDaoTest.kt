package com.faskn.persistence

import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.faskn.data.response.PhotosItem
import com.faskn.persistence.dao.NearbySearchDao
import com.faskn.persistence.entity.ResultsEntity
import com.google.common.truth.Truth
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

/**
 * Created by Furkan on 19.07.2020
 */

@Config(sdk = [Build.VERSION_CODES.P])
@RunWith(AndroidJUnit4::class)
class NearbyDaoTest {

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var placesDatabase: PlacesDatabase
    private lateinit var nearbySearchDao: NearbySearchDao

    @Before
    fun setUp() {
        placesDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            PlacesDatabase::class.java
        )
            .allowMainThreadQueries()
            .build()

        nearbySearchDao = placesDatabase.nearbySearchDao()
    }

    @After
    fun closeDatabase() {
        placesDatabase.close()
    }

    @Test
    fun `insert one entity and db count must be 1`() {
        // When
        nearbySearchDao.insertNearbyPlace(listOf(generatePlace("1")))
        // Then
        val count = nearbySearchDao.getCount()
        Truth.assertThat(count).isEqualTo(1)
    }

    @Test
    fun `insert multiple entites and then delete all finally count must be zero`() {
        // When
        nearbySearchDao.insertNearbyPlace(listOf(generatePlace("1")))
        nearbySearchDao.insertNearbyPlace(listOf(generatePlace("2")))
        nearbySearchDao.insertNearbyPlace(listOf(generatePlace("3")))

        val count = nearbySearchDao.getCount()
        Truth.assertThat(count).isEqualTo(3)

        // Then
        nearbySearchDao.deleteAll()
        val newCount = nearbySearchDao.getCount()
        Truth.assertThat(newCount).isEqualTo(0)
    }

    @Test
    fun `when is empty count must be 0`() {
        // When
        val count = nearbySearchDao.getCount()

        // Then
        Truth.assertThat(count).isEqualTo(0)
    }

    private fun generatePlace(id: String): ResultsEntity {
        return ResultsEntity(
            id = id,
            name = "Test",
            photos = listOf(generatePhoto()),
            types = listOf("test", "place")
        )
    }

    private fun generatePhoto(): PhotosItem {
        return PhotosItem(
            photoReference = "asd",
            width = 1920,
            htmlAttributions = null,
            height = 1080
        )
    }
}
