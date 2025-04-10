package org.example.basic_cmp_project.data.dataStore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import okio.Path.Companion.toPath

typealias PrefsDataStore = DataStore<Preferences>

fun createDataStore(productPath: () -> String): PrefsDataStore =
    PreferenceDataStoreFactory.createWithPath(produceFile = { productPath().toPath() })

const val dataStoreFileName = "cmp.preferences_pb"