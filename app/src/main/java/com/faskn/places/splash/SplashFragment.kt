package com.faskn.places.splash

import android.Manifest
import android.annotation.SuppressLint
import android.os.Looper
import androidx.navigation.fragment.findNavController
import com.faskn.core.base.BaseFragment
import com.faskn.core.base.Constants
import com.faskn.core.utils.extensions.toast
import com.faskn.places.R
import com.faskn.places.databinding.FragmentSplashBinding
import com.google.android.gms.location.*
import dagger.hilt.android.AndroidEntryPoint
import pub.devrel.easypermissions.EasyPermissions
import pub.devrel.easypermissions.PermissionRequest

@AndroidEntryPoint
class SplashFragment :
    BaseFragment<SplashViewModel, FragmentSplashBinding>(
        R.layout.fragment_splash,
        SplashViewModel::class.java
    ),
    EasyPermissions.PermissionCallbacks {

    private val locationPerm = Manifest.permission.ACCESS_FINE_LOCATION
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var locationCallback: LocationCallback

    override fun init() {
        binding.viewModel = viewModel
        binding.executePendingBindings()
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
        locationCallback = object : LocationCallback() {

            override fun onLocationResult(it: LocationResult?) {
                super.onLocationResult(it)
                if (it != null) {
                    viewModel.saveLocation(
                        it.locations.last()?.latitude.toString(),
                        it.locations.last()?.longitude.toString()
                    ).apply {
                        findNavController().navigate(R.id.action_splashFragment_to_dashboardFragment)
                    }
                } else {
                    toast(getString(R.string.no_location_detected))
                }
            }
        }

        if (EasyPermissions.hasPermissions(requireContext(), locationPerm)) {
            updateLocation()
        } else
            EasyPermissions.requestPermissions(
                PermissionRequest.Builder(
                    this,
                    Constants.PermissionCodes.RC_LOCATION,
                    locationPerm
                )
                    .setRationale(getString(R.string.request_location_text))
                    .setPositiveButtonText(getString(R.string.ok))
                    .setNegativeButtonText(getString(R.string.cancel))
                    .build()
            )
    }

    @SuppressLint("MissingPermission")
    fun updateLocation() {
        fusedLocationClient.requestLocationUpdates(
            LocationRequest.create().setNumUpdates(1).setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY).setInterval(20 * 1000), locationCallback,
            Looper.getMainLooper()
        )
    }

    override fun onPause() {
        super.onPause()
        fusedLocationClient.removeLocationUpdates(locationCallback)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        if (requestCode == Constants.PermissionCodes.RC_LOCATION)
            toast(getString(R.string.location_perm_denied_text))
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        if (requestCode == Constants.PermissionCodes.RC_LOCATION)
            updateLocation()
    }
}
