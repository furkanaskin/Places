package com.faskn.core.utils

import androidx.lifecycle.LiveData

/**
 * Created by Furkan on 12.07.2020
 */

abstract class UseCaseLiveData<M, P, R> {

    abstract fun getRepository(): R

    abstract fun buildUseCaseObservable(params: P?): LiveData<M>

    /**
     * Executes the target call
     *
     * @param params represents params to be passed
     * @return [Disposable] result
     */

    fun execute(params: P?): LiveData<M> {
        return buildUseCaseObservable(params)
    }

    abstract class Params

    class None
}
