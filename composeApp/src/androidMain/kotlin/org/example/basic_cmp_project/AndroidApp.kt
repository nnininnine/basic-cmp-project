package org.example.basic_cmp_project

import android.app.Application
import org.example.basic_cmp_project.di.initKoin

class AndroidApp: Application() {
    override fun onCreate() {
        super.onCreate()
        // start koin

        initKoin(this@AndroidApp)
    }
}