package pt.mrpeace.development.timeexampleapp.repo

import android.content.Context
import kotlinx.coroutines.delay

class SharedPreferencesWrapper(context: Context) {
    private var sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    suspend fun setTimeString(timeString: String):String
    {
        delay(1000L) // pretend we are doing something useful
        sharedPreferences.edit().putString(KEY,timeString).apply()
        return getTimeString()
    }

    suspend fun getTimeString(): String {
        delay(1000L) // pretend we are doing something useful
        return sharedPreferences.getString(KEY,DEFAULT_VALUE) ?: DEFAULT_VALUE
    }

    companion object {
        private const val PREFS_NAME = "time_example_preferences"
        private const val KEY = "time_key"
        private const val DEFAULT_VALUE = ""
    }
}