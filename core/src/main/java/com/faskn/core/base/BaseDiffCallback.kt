package com.faskn.core.base

import androidx.recyclerview.widget.DiffUtil

/**
 * Created by Furkan on 15.07.2020
 */

open class BaseDiffCallback<T> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T) = oldItem == newItem

    override fun areContentsTheSame(oldItem: T, newItem: T) = oldItem == newItem
}
