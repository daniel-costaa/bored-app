package com.example.boredapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.boredapplication.data.models.ActivityStatus
import com.example.boredapplication.data.models.ActivityTypes
import com.example.boredapplication.data.models.BoredActivityUi
import com.example.boredapplication.data.repositories.BoredRepository
import kotlinx.coroutines.launch

class BoredViewModel(private val boredRepository: BoredRepository) : ViewModel() {
    private val _currentActivity = MutableLiveData<BoredActivityUi>()
    val currentActivity: LiveData<BoredActivityUi>; get() = _currentActivity

    private val _selectedActivityType = MutableLiveData<ActivityTypes?>()

    var startTime: Long = 0L

    fun getActivity() {
        viewModelScope.launch {
            val activity = boredRepository.getRandomActivity(_selectedActivityType.value)
            _currentActivity.postValue(activity)
        }
    }

    fun saveActivity() {
        viewModelScope.launch {
            currentActivity.value?.let {
                boredRepository.saveActivity(it)
            }
        }
    }

    fun updateExtraData(status: ActivityStatus) {
        viewModelScope.launch {
            val timeSpent = System.currentTimeMillis() - startTime
            currentActivity.value?.let {
                boredRepository.updateExtraData(it.key, status, timeSpent)
            }
        }
    }

    fun setStartTime() {
        startTime = System.currentTimeMillis()
    }

    fun setActivityType(type: ActivityTypes?) {
        _selectedActivityType.value = type
    }
}
