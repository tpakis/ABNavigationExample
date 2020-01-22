package com.example.abnavigationexample.ui.abtest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.abnavigationexample.NO_NEXT_STEP
import com.example.abnavigationexample.OneTimeEvent

class ActivityViewModel(private val variation: ABTestVariation) : ViewModel() {

    private val _navEvent = MutableLiveData<OneTimeEvent<Int>>()
    val navEvent: LiveData<OneTimeEvent<Int>> = _navEvent

    fun endedStepNavigateToNext(currentStep: Int) {
        _navEvent.value =
            OneTimeEvent(
                if (currentStep < variation.totalNumberOfSteps) {
                    currentStep.plus(1)
                } else {
                    NO_NEXT_STEP
                }
            )
    }

    @Suppress("UNCHECKED_CAST")
    class ActivityViewModelFactory(
        private val variation: ABTestVariation
    ) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>) =
            (ActivityViewModel(variation) as T)
    }
}