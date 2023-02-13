package com.example.gymhelper.layer.data.repository.exercise

import com.example.gymhelper.layer.data.local.exercise.ExerciseEntity
import com.example.gymhelper.layer.data.local.exercise.ExerciseLocalDataSource
import com.example.gymhelper.layer.data.local.exercise.PlanEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ExerciseRepositoryImpl @Inject constructor(
    private val exerciseLocalDataSource: ExerciseLocalDataSource
) : ExerciseRepository {
    override suspend fun insertPlan(planEntity: PlanEntity): Long {
        return exerciseLocalDataSource.insertPlan(planEntity)
    }

    override suspend fun deletePlan(planId: Int) {
        exerciseLocalDataSource.deletePlan(planId)
    }


    override suspend fun getPlans(): Flow<List<PlanEntity>> {
        return exerciseLocalDataSource.getAllPlan()
    }

    override suspend fun insertExercise(exerciseEntity: ExerciseEntity) {
        exerciseLocalDataSource.insertExercise(exerciseEntity)
    }

    override suspend fun insertExercises(exercises: List<ExerciseEntity>) {
        exerciseLocalDataSource.insertExercises(exercises)
    }

    override suspend fun getExercisesByPlanId(planId: Long): Flow<List<ExerciseEntity>> {
        return exerciseLocalDataSource.getExerciseWithPlanId(planId)
    }


}