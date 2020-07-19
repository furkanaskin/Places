package com.faskn.core.utils

/**
 * Created by Furkan on 12.07.2020
 */

interface Mapper<R, D> {
    fun mapFrom(type: R): D
}
