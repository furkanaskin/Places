package com.faskn.places.detail

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.updateLayoutParams
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.faskn.core.base.BaseFragment
import com.faskn.core.utils.extensions.alertDialog
import com.faskn.core.utils.extensions.toast
import com.faskn.places.R
import com.faskn.places.databinding.FragmentPlaceDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.CompletableObserver
import io.reactivex.disposables.Disposable

@AndroidEntryPoint
class PlaceDetailFragment : BaseFragment<PlaceDetailViewModel, FragmentPlaceDetailBinding>(
    R.layout.fragment_place_detail, PlaceDetailViewModel::class.java
) {

    private val placeDetailFragmentArgs: PlaceDetailFragmentArgs by navArgs()

    override fun init() {
        setHasOptionsMenu(true)
        binding.viewModel = viewModel
        viewModel.item.set(placeDetailFragmentArgs.detail).apply {
            viewModel.updateAsVisited()
        }
        binding.imageViewCoverPhoto.updateLayoutParams<ConstraintLayout.LayoutParams> {
            dimensionRatio = viewModel.item.get()?.getLargestPhotoDimension()
        }
        binding.ratingBar.rating = viewModel.item.get()?.rating?.toFloat() ?: 0f
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_place_detail, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_delete -> {
            alertDialog {
                setTitle(getString(R.string.wanna_delete_this_place))
                setPositiveButton(
                    getString(R.string.yes)
                ) { _, _ ->
                    viewModel.removePlace().subscribe(object : CompletableObserver {
                        override fun onComplete() {
                            findNavController().popBackStack()
                        }

                        override fun onSubscribe(d: Disposable) {
                        }

                        override fun onError(e: Throwable) {
                            toast(getString(R.string.something_went_wrong))
                        }
                    })
                }

                setNegativeButton(
                    getString(R.string.no)
                ) { dialog, _ ->
                    dialog.dismiss()
                }
            }?.show()
            true
        }

        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }
}
