package com.example.boredapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.boredapplication.data.models.ActivityTypes
import com.example.boredapplication.data.models.BoredActivityUi
import com.example.boredapplication.data.repositories.BoredRepository
import kotlinx.coroutines.launch

class BoredViewModel(private val boredRepository: BoredRepository) : ViewModel() {
    private val _currentActivity = MutableLiveData<BoredActivityUi>()
    val currentActivity: LiveData<BoredActivityUi>; get() = _currentActivity

    fun getActivity(type: ActivityTypes?) {
        viewModelScope.launch {
            val activity = boredRepository.getRandomActivity(type)
            _currentActivity.postValue(activity)
        }
    }
}
