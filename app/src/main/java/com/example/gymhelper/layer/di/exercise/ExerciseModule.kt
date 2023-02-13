package com.example.gymhelper.layer.di.exercise

import com.example.gymhelper.core.data.GymHelperDataBase
import com.example.gymhelper.layer.data.local.exercise.ExerciseDao
import com.example.gymhelper.layer.data.local.exercise.ExerciseLocalDataSource
import com.example.gymhelper.layer.data.local.exercise.ExerciseLocalDataSourceImpl
import com.example.gymhelper.layer.data.local.exercise.PlanDao
import com.example.gymhelper.layer.data.repository.exercise.ExerciseRepository
import com.example.gymhelper.layer.data.repository.exercise.ExerciseRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ExerciseModule {

    @Binds
    abstract fun bindExerciseRepository(exerciseRepositoryImpl: ExerciseRepositoryImpl): ExerciseRepository

    @Binds
    abstract fun bindExerciseLocalDataSource(exerciseLocalDataSourceImpl: ExerciseLocalDataSourceImpl)
            : ExerciseLocalDataSource

    companion object {
        @Provides
        fun provideExerciseDao(gymHelperDataBase: GymHelperDataBase): ExerciseDao {
            return gymHelperDataBase.getExercise()
        }

        @Provides
        fun providePlanDao(gymHelperDataBase: GymHelperDataBase): PlanDao {
            return gymHelperDataBase.getPlan()
        }

    }
}