package com.example.gymhelper.layer.ui.exercise.viewModel

import androidx.lifecycle.ViewModel
import com.example.gymhelper.R
import com.example.gymhelper.layer.data.repository.exercise.ExerciseRepository
import com.example.gymhelper.layer.ui.exercise.model.PlanView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class AddPlanViewModel @Inject constructor(
    private val exerciseRepository: ExerciseRepository
) : ViewModel(){
    private val _message = MutableSharedFlow<Int>()
    val message = _message.asSharedFlow()

    fun addPlan(planView: PlanView) = flow {
        if(planView.planName.isEmpty())
            _message.emit(R.string.msg_plan_name_empty)
        else if(planView.planRestTime <=0)
            _message.emit(R.string.msg_rest_time_empty)
        else
            emit(exerciseRepository.insertPlan(planView.toPlanEntity()))
    }.flowOn(Dispatchers.IO)
}