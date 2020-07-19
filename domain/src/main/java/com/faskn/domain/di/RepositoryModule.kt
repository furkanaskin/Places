package com.faskn.domain.di

import com.faskn.domain.datasource.NearbySearchLocalDataSource
import com.faskn.domain.datasource.NearbySearchRemoteDataSource
import com.faskn.domain.repository.NearbySearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

/**
 * Created by Furkan on 16.07.2020
 */

@Module
@InstallIn(ActivityRetainedComponent::class)
class RepositoryModule {
    @Provides
    @ActivityRetainedScoped
    fun provideNearbySearchRepository(
        nearbySearchLocalDataSource: NearbySearchLocalDataSource,
        nearbySearchRemoteDataSource: NearbySearchRemoteDataSource
    ): NearbySearchRepository {
        return NearbySearchRepository(nearbySearchLocalDataSource, nearbySearchRemoteDataSource)
    }
}
