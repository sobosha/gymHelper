package com.example.gymhelper.layer.data.local.exercise

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseDao {

    @Insert
    fun insertExercise(exerciseEntity: ExerciseEntity)

    @Insert
    fun insertExercises(exercises: List<ExerciseEntity>)

    @Query("DELETE FROM ExerciseEntity WHERE id =:id")
    fun deleteExercise(id: Int)

    @Query("SELECT * FROM ExerciseEntity WHERE planId = :planId")
    fun getExerciseWithPlanId(planId: Long): Flow<List<ExerciseEntity>>

    @Query("DELETE FROM ExerciseEntity WHERE id in (:idList)")
    fun deleteExercise(idList: List<Int>)
}