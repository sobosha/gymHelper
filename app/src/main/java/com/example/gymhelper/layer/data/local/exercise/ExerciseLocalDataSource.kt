package com.example.gymhelper.layer.data.local.exercise

import kotlinx.coroutines.flow.Flow

interface ExerciseLocalDataSource {

    suspend fun insertPlan(planEntity: PlanEntity) : Long
    suspend fun getAllPlan() : Flow<List<PlanEntity>>
    suspend fun deletePlan(planId : Int)
    suspend fun insertExercise(exerciseEntity: ExerciseEntity)
    suspend fun deleteExercise(exerciseId : Int)
    suspend fun deleteExercise(exercisesId : List<Int>)
    suspend fun getExerciseWithPlanId(planId: Long) : Flow<List<ExerciseEntity>>
    suspend fun insertExercises(exercises : List<ExerciseEntity>)
}