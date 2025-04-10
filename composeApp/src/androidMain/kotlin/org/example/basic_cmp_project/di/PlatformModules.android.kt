package org.example.basic_cmp_project.di

import android.content.Context
import org.example.basic_cmp_project.data.dataStore.PrefsDataStore
import org.example.basic_cmp_project.data.dataStore.createDataStore
import org.example.basic_cmp_project.data.dataStore.dataStoreFileName
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModules: Module = module {
    single<PrefsDataStore> {
        createDataStore(
            productPath = {
                get<Context>().filesDir.resolve(dataStoreFileName).absolutePath
            }
        )
    }
}