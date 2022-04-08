package com.example.mybasetemplate.data

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.mybasetemplate.enums.IntroFeatures
import kotlinx.coroutines.flow.Flow
import java.io.IOException

class IntroRepository(private val dataStore: DataStore<Preferences>) {

    private val TAG: String = "UserPreferencesRepo"

    private object PreferencesKeys {
        val SORT_ORDER = stringPreferencesKey("sort_order")
        val SHOW_COMPLETED = booleanPreferencesKey("show_completed")
    }

//    /**
//     * Get the user preferences flow.
//     */
//    val userPreferencesFlow: Flow<IntroFeatureData> = dataStore.data
//        .catch { exception ->
//            // dataStore.data throws an IOException when an error is encountered when reading data
//            if (exception is IOException) {
//                Log.e(TAG, "Error reading preferences.", exception)
//                emit(emptyPreferences())
//            } else {
//                throw exception
//            }
//        }.map { preferences ->
//            mapUserPreferences(preferences)
//        }


    private fun mapUserPreferences(preferences: Preferences): IntroFeatureData {
        return IntroFeatureData(1, IntroFeatures.FEATURE_MATERIAL)
    }
}
