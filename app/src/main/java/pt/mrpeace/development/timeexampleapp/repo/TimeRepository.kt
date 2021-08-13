package pt.mrpeace.development.timeexampleapp.repo

class TimeRepository(private val sharedPreferences: SharedPreferencesWrapper) {
    suspend fun getTime() = sharedPreferences.getTimeString()
    suspend fun setTime(timeString:String) = sharedPreferences.setTimeString(timeString)
}