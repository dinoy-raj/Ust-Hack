package com.dinoy.forkcast

import android.app.Application
import com.google.firebase.FirebaseApp
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ForkCastApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
