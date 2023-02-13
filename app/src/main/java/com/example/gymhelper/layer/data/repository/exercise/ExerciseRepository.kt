package com.example.gymhelper.layer.data.repository.exercise

import com.example.gymhelper.layer.data.local.exercise.ExerciseEntity
import com.example.gymhelper.layer.data.local.exercise.PlanEntity
import kotlinx.coroutines.flow.Flow

interface ExerciseRepository {
    suspend fun insertPlan(planEntity: PlanEntity) : Long
    suspend fun deletePlan(planId : Int)
    suspend fun getPlans() : Flow<List<PlanEntity>>
    suspend fun insertExercise(exerciseEntity: ExerciseEntity)
    suspend fun insertExercises(exercises : List<ExerciseEntity>)
    suspend fun getExercisesByPlanId(planId : Long) : Flow<List<ExerciseEntity>>

}