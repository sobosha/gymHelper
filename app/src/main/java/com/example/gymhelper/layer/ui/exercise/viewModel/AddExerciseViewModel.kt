package com.example.gymhelper.layer.ui.exercise.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gymhelper.R
import com.example.gymhelper.layer.data.repository.exercise.ExerciseRepository
import com.example.gymhelper.layer.ui.exercise.model.ExerciseView
import com.example.gymhelper.layer.ui.exercise.model.toExerciseView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddExerciseViewModel @Inject constructor(
    private val exerciseRepository: ExerciseRepository
) : ViewModel() {

    private val _message = MutableSharedFlow<Int>()
    val message = _message.asSharedFlow()

    private val _planId = MutableStateFlow<Long>(0)

    val exercises = _planId.flatMapLatest {
        exerciseRepository.getExercisesByPlanId(it).map { exerciseList ->
            exerciseList.map { exerciseEntity ->
                exerciseEntity.toExerciseView()
            }
        }
    }

    fun addExercise(exerciseView: ExerciseView) {
        viewModelScope.launch(Dispatchers.IO) {
            if (exerciseView.exerciseName.isEmpty()) {
                _message.emit(R.string.msg_exercise_name_empty)
            } else if (exerciseView.exerciseSet <= 0) {
                _message.emit(R.string.msg_set_empty)
            } else if (exerciseView.exerciseRepeat.isEmpty()) {
                _message.emit(R.string.msg_exercise_repeat_empty)
            } else {
                exerciseView.planId = _planId.value
                exerciseRepository.insertExercise(exerciseView.toExerciseEntity())
            }
        }
    }

    fun setPlanId(planId: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            _planId.emit(planId)
        }
    }
}