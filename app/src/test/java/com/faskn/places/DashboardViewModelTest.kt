package com.faskn.places

import android.content.SharedPreferences
import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.faskn.core.utils.domain.Status
import com.faskn.domain.usecase.NearbySearchUseCase
import com.faskn.domain.viewState.NearbySearchViewState
import com.faskn.places.dashboard.DashboardViewModel
import com.google.common.truth.Truth
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.verify
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
class DashboardViewModelTest {

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @MockK
    lateinit var useCase: NearbySearchUseCase

    @MockK
    lateinit var sharedPreferences: SharedPreferences

    private lateinit var dashboardViewModel: DashboardViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        dashboardViewModel = DashboardViewModel(sharedPreferences, useCase)
    }

    @Test
    fun `given loading state, when setParams called, then update live data for loading status`() {
        // Given
        val viewStateObserver: Observer<NearbySearchViewState> = mockk(relaxUnitFun = true)
        dashboardViewModel.nearbyPlacesViewState.observeForever(viewStateObserver)

        val viewStateLiveData: MutableLiveData<NearbySearchViewState> = MutableLiveData()
        viewStateLiveData.postValue(NearbySearchViewState(Status.LOADING, null, null))

        // When
        every { sharedPreferences.getString(any(), any()) } returns "34"
        every { useCase.execute(any()) } returns viewStateLiveData

        dashboardViewModel.setParams()

        // Then
        val forecastViewStateSlots = mutableListOf<NearbySearchViewState>()
        verify { viewStateObserver.onChanged(capture(forecastViewStateSlots)) }

        val loadingState = forecastViewStateSlots[0]
        Truth.assertThat(loadingState.status).isEqualTo(Status.LOADING)
    }

    @Test
    fun `given success state, when setParams called, then update live data for success status`() {
        // Given
        val viewStateObserver: Observer<NearbySearchViewState> = mockk(relaxUnitFun = true)
        dashboardViewModel.nearbyPlacesViewState.observeForever(viewStateObserver)

        val viewStateLiveData: MutableLiveData<NearbySearchViewState> = MutableLiveData()
        viewStateLiveData.postValue(NearbySearchViewState(Status.SUCCESS, null, null))

        // When
        every { sharedPreferences.getString(any(), any()) } returns "34"
        every { useCase.execute(any()) } returns viewStateLiveData

        dashboardViewModel.setParams()

        // Then
        val forecastViewStateSlots = mutableListOf<NearbySearchViewState>()
        verify { viewStateObserver.onChanged(capture(forecastViewStateSlots)) }

        val loadingState = forecastViewStateSlots[0]
        Truth.assertThat(loadingState.status).isEqualTo(Status.SUCCESS)
    }

    @Test
    fun `given error state, when setParams called, then update live data for error status`() {
        // Given
        val viewStateObserver: Observer<NearbySearchViewState> = mockk(relaxUnitFun = true)
        dashboardViewModel.nearbyPlacesViewState.observeForever(viewStateObserver)

        val viewStateLiveData: MutableLiveData<NearbySearchViewState> = MutableLiveData()
        viewStateLiveData.postValue(NearbySearchViewState(Status.ERROR, "Unhandled Exception", null))

        // When
        every { sharedPreferences.getString(any(), any()) } returns "34"
        every { useCase.execute(any()) } returns viewStateLiveData

        dashboardViewModel.setParams()

        // Then
        val forecastViewStateSlots = mutableListOf<NearbySearchViewState>()
        verify { viewStateObserver.onChanged(capture(forecastViewStateSlots)) }

        val loadingState = forecastViewStateSlots[0]
        Truth.assertThat(loadingState.status).isEqualTo(Status.ERROR)
    }
}
