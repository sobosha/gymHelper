package com.example.gymhelper.core.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gymhelper.layer.data.local.exercise.ExerciseDao
import com.example.gymhelper.layer.data.local.exercise.ExerciseEntity
import com.example.gymhelper.layer.data.local.exercise.PlanDao
import com.example.gymhelper.layer.data.local.exercise.PlanEntity

@Database(
    entities = [
        PlanEntity::class,
        ExerciseEntity::class
    ], version = 1
)
abstract class GymHelperDataBase : RoomDatabase() {
    abstract fun getExercise(): ExerciseDao
    abstract fun getPlan(): PlanDao
}