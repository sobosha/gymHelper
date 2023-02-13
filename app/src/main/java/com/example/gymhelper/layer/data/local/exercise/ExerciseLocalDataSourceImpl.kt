package com.example.gymhelper.layer.data.local.exercise

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ExerciseLocalDataSourceImpl @Inject constructor(
    private val exerciseDao: ExerciseDao ,
    private val planDao: PlanDao
) : ExerciseLocalDataSource{
    override suspend fun insertPlan(planEntity: PlanEntity): Long {
        return planDao.insertPlan(planEntity)
    }

    override suspend fun getAllPlan(): Flow<List<PlanEntity>> {
        return planDao.getAllPlan()
    }

    override suspend fun deletePlan(planId: Int) {
        planDao.deletePlan(planId)
    }

    override suspend fun insertExercise(exerciseEntity: ExerciseEntity) {
        exerciseDao.insertExercise(exerciseEntity)
    }

    override suspend fun deleteExercise(exerciseId: Int) {
        exerciseDao.deleteExercise(exerciseId)
    }

    override suspend fun deleteExercise(exercisesId: List<Int>) {
        exerciseDao.deleteExercise(exercisesId)
    }

    override suspend fun getExerciseWithPlanId(planId: Long): Flow<List<ExerciseEntity>> {
        return exerciseDao.getExerciseWithPlanId(planId)
    }

    override suspend fun insertExercises(exercises: List<ExerciseEntity>) {
        exerciseDao.insertExercises(exercises)
    }


}