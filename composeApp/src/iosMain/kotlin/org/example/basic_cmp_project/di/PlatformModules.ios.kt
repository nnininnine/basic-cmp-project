package org.example.basic_cmp_project.di

import kotlinx.cinterop.ExperimentalForeignApi
import org.example.basic_cmp_project.data.dataStore.PrefsDataStore
import org.example.basic_cmp_project.data.dataStore.createDataStore
import org.example.basic_cmp_project.data.dataStore.dataStoreFileName
import org.koin.core.module.Module
import org.koin.dsl.module
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL
import platform.Foundation.NSUserDomainMask

@OptIn(ExperimentalForeignApi::class)
actual val platformModules: Module = module {
    single<PrefsDataStore> {
        createDataStore(
            productPath = {
                val documentDirectory: NSURL? = NSFileManager.defaultManager.URLForDirectory(
                    directory = NSDocumentDirectory,
                    inDomain = NSUserDomainMask,
                    appropriateForURL = null,
                    create = false,
                    error = null,
                )
                requireNotNull(documentDirectory).path + "/$dataStoreFileName"
            }
        )
    }
}