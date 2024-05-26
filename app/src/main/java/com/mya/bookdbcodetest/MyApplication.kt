/*
 * Mya Than Htet
 * Copyright (c) 2024.
 */

package com.mya.bookdbcodetest

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {

    companion object {
        var instance: MyApplication? = null
            private set
        val context: Context?
            get() = instance
    }

    override fun onCreate() {
        instance = this
        super.onCreate()
    }
}