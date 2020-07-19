package com.faskn.core.base

import com.faskn.core.utils.domain.Status

/**
 * Created by Furkan on 15.07.2020
 */

open class BaseViewState(val baseStatus: Status, val baseError: String?) {
    fun isLoading() = baseStatus == Status.LOADING
    fun getErrorMessage() = baseError
    fun shouldShowErrorMessage() = baseError != null
}
