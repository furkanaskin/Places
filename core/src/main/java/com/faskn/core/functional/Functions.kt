package com.faskn.core.functional

/**
 * Created by Furkan on 12.07.2020
 */

typealias Supplier<T> = () -> T

interface Consumer<T> {

    fun accept(t: T)
}
