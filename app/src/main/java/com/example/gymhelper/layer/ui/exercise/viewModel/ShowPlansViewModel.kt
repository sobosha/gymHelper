package com.example.gymhelper.layer.ui.exercise.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gymhelper.layer.data.repository.exercise.ExerciseRepository
import com.example.gymhelper.layer.ui.exercise.model.PlanView
import com.example.gymhelper.layer.ui.exercise.model.toPlanView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShowPlansViewModel @Inject constructor(
    private val exerciseRepository: ExerciseRepository
) : ViewModel() {

    init {
        getPlans()
    }

    private val _plans = MutableStateFlow<List<PlanView>>(listOf())
    val plans = _plans.asStateFlow()

    private fun getPlans() {
        viewModelScope.launch(Dispatchers.IO) {
            _plans.emitAll(exerciseRepository.getPlans().mapLatest { planList ->
                planList.map {
                    it.toPlanView()
                }
            })
        }
    }
}