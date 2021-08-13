package pt.mrpeace.development.timeexampleapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pt.mrpeace.development.timeexampleapp.repo.TimeRepository
import pt.mrpeace.development.timeexampleapp.utils.TAG

class TimePickerViewModel(private val timeRepository: TimeRepository) : ViewModel()
{

    private val _timeText = MutableLiveData<String>()
    val timeText: LiveData<String>
        get() = _timeText


    fun setTime(s:String){
        viewModelScope.launch {
            try {
                _timeText.value = timeRepository.setTime(s)
            }
            catch (exception: Exception){
                Log.e(TAG,"${this::class.simpleName}: $exception")
            }
        }
    }




}