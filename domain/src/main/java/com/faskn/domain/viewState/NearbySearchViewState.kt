package com.faskn.domain.viewState

import com.faskn.core.base.BaseViewState
import com.faskn.core.base.Constants
import com.faskn.core.utils.domain.Status
import com.faskn.domain.R
import com.faskn.persistence.entity.NearbySearchEntity

/**
 * Created by Furkan on 16.07.2020
 */

class NearbySearchViewState(
    val status: Status,
    val error: String? = null,
    val data: NearbySearchEntity? = null
) : BaseViewState(status, error) {

    fun getNearbyPlaces() = data
    fun isSuccess() = data?.status == Constants.StatusCodes.OK && status == Status.SUCCESS
    fun isInvalid() = data?.status != Constants.StatusCodes.OK && status == Status.SUCCESS

    fun getApiErrorMessage(): Int {
        return when (data?.status) {
            Constants.StatusCodes.INVALID_REQUEST -> R.string.something_went_wrong
            Constants.StatusCodes.OVER_QUERY_LIMIT -> R.string.try_again_later
            Constants.StatusCodes.REQUEST_DENIED -> R.string.try_again_later
            Constants.StatusCodes.ZERO_RESULTS -> R.string.no_results
            Constants.StatusCodes.UNKNOWN_ERROR -> R.string.something_went_wrong
            else -> R.string.something_went_wrong
        }
    }
}
