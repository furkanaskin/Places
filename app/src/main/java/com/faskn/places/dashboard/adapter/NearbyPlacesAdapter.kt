package com.faskn.places.dashboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.faskn.core.base.BaseAdapter
import com.faskn.persistence.entity.ResultsEntity
import com.faskn.places.databinding.ItemNearbyPlacesBinding

/**
 * Created by Furkan on 16.07.2020
 */

class NearbyPlacesAdapter(private val clickCallback: ((ResultsEntity) -> Unit)) :
    BaseAdapter<ResultsEntity>(object : DiffUtil.ItemCallback<ResultsEntity>() {
        override fun areItemsTheSame(oldItem: ResultsEntity, newItem: ResultsEntity): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: ResultsEntity,
            newItem: ResultsEntity
        ): Boolean {
            return oldItem == newItem
        }
    }) {

    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
        val viewModel = NearbyPlacesItemViewModel()
        val binding: ItemNearbyPlacesBinding =
            ItemNearbyPlacesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        binding.viewModel = viewModel
        binding.rootView.setOnClickListener {
            binding.viewModel?.item?.get()?.let { it1 ->
                clickCallback.invoke(
                    it1
                )
            }
        }
        return binding
    }

    override fun bind(binding: ViewDataBinding, position: Int) {
        (binding as ItemNearbyPlacesBinding).viewModel?.item?.set(getItem(position))
        binding.executePendingBindings()
    }
}
