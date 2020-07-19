package com.faskn.places.dashboard

import android.content.res.Configuration
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.faskn.core.base.BaseFragment
import com.faskn.core.utils.extensions.observeWith
import com.faskn.places.R
import com.faskn.places.dashboard.adapter.NearbyPlacesAdapter
import com.faskn.places.databinding.FragmentDashboardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : BaseFragment<DashboardViewModel, FragmentDashboardBinding>(
    R.layout.fragment_dashboard,
    DashboardViewModel::class.java
) {
    lateinit var snapHelper: LinearSnapHelper

    override fun init() {
        binding.viewModel = viewModel
        viewModel.setParams()
        initNearbyPlacesAdapter()

        viewModel.nearbyPlacesViewState.observeWith(viewLifecycleOwner) {
            with(binding) {
                viewState = it
                if (it.isSuccess())
                (binding.recyclerViewNearbyPlaces.adapter as NearbyPlacesAdapter).submitList(it.getNearbyPlaces()?.results?.sortedBy { it?.userRatingsTotal })
            }
        }
    }

    private fun initNearbyPlacesAdapter() {
        val adapter = NearbyPlacesAdapter {
            val action =
                DashboardFragmentDirections.actionDashboardFragmentToPlaceDetailFragment(
                    it.name ?: getString(R.string.app_name), it
                )
            navigate(action)
        }

        binding.recyclerViewNearbyPlaces.adapter = adapter
        binding.recyclerViewNearbyPlaces.adapter!!.stateRestorationPolicy =
            RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY

        val currentOrientation = resources.configuration.orientation
        if (currentOrientation == Configuration.ORIENTATION_PORTRAIT)
            attachSnapHelper()
        else
            detachSnapHelper() // Detach it, we don't need an snapHelper for Landscape mode.
    }

    private fun attachSnapHelper() {
        if (!::snapHelper.isInitialized) {
            snapHelper = LinearSnapHelper()
            snapHelper.attachToRecyclerView(binding.recyclerViewNearbyPlaces)
        } else {
            snapHelper.attachToRecyclerView(null) // Detach it first.
            snapHelper.attachToRecyclerView(binding.recyclerViewNearbyPlaces)
        }
    }

    private fun detachSnapHelper() {
        if (!::snapHelper.isInitialized) {
            snapHelper = LinearSnapHelper()
            snapHelper.attachToRecyclerView(null)
        } else {
            snapHelper.attachToRecyclerView(null)
        }
    }
}
