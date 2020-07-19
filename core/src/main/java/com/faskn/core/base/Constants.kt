package com.faskn.core.base

/**
 * Created by Furkan on 15.07.2020
 */

object Constants {
    object NetworkService {
        const val BASE_URL = "https://maps.googleapis.com/maps/api/"
        // TODO: 20.07.2020 - Update API_KEY with your own key.
        const val API_KEY = ""
        const val BASE_IMAGE_URL = "https://maps.googleapis.com/maps/api/place/photo?"
        const val RATE_LIMITER_TYPE = "data"
    }

    object PlaceTypes {
        const val PLACE_TYPE_RESTAURANT = "restaurant"
    }

    object Coordinates {
        const val LAT = "lat"
        const val LON = "lon"
    }

    object StatusCodes {
        const val OK = "OK"
        const val ZERO_RESULTS = "ZERO_RESULTS"
        const val OVER_QUERY_LIMIT = "OVER_QUERY_LIMIT"
        const val REQUEST_DENIED = "REQUEST_DENIED"
        const val INVALID_REQUEST = "INVALID_REQUEST"
        const val UNKNOWN_ERROR = "UNKNOWN_ERROR"
    }

    object PermissionCodes {
        const val RC_LOCATION = 1881
    }
}
