package com.faskn.places.base

import android.app.Application
import android.os.Build
import com.facebook.stetho.Stetho
import com.faskn.core.logger.initLogger
import com.faskn.places.BuildConfig
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by Furkan on 12.07.2020
 */

@HiltAndroidApp
open class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        initLogger(BuildConfig.DEBUG)
        initStetho()
    }

    companion object {
        lateinit var INSTANCE: BaseApplication
    }

    private fun initStetho() {
        if (BuildConfig.DEBUG && isRoboUnitTest().not())
            Stetho.initializeWithDefaults(this)
    }

    private fun isRoboUnitTest(): Boolean {
        return "robolectric" == Build.FINGERPRINT
    }
}
