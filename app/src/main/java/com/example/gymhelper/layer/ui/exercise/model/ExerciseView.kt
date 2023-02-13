package com.example.gymhelper.layer.ui.exercise.model

import com.example.gymhelper.layer.data.local.exercise.ExerciseEntity

data class ExerciseView(
    val exerciseName: String,
    val exerciseSet: Int,
    val exerciseRepeat: String,
    val id: Int = 0,
    var planId: Long = 0
) {
    fun toExerciseEntity() = ExerciseEntity(
        exerciseName = exerciseName,
        exerciseSet = exerciseSet,
        exerciseRepeat = exerciseRepeat,
        planId = planId
    )
}

fun ExerciseEntity.toExerciseView() = ExerciseView(
    exerciseName, exerciseSet, exerciseRepeat, id, planId
)