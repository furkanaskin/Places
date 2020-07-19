package com.faskn.core.logger

import android.util.Log
import timber.log.Timber

/**
 * Created by Furkan on 12.07.2020
 */

class CrashReportingTree : Timber.Tree() {

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            return
        }

        FakeCrashLibrary.log(priority, tag, message)

        if (t != null) {
            if (priority == Log.ERROR) {
                FakeCrashLibrary.logError(t)
            } else if (priority == Log.WARN) {
                FakeCrashLibrary.logWarning(t)
            }
        }
    }
}

private class FakeCrashLibrary private constructor() {

    init {
        throw AssertionError("No instances.")
    }

    companion object {
        fun log(priority: Int, tag: String?, message: String) {
        }

        fun logWarning(t: Throwable) {
        }

        fun logError(t: Throwable) {
        }
    }
}
