package com.example.gymhelper.core.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gymhelper.R
import com.example.gymhelper.core.data.GymHelperDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideAppDatabase(app : Application) : GymHelperDataBase {
        return Room.databaseBuilder(app , GymHelperDataBase::class.java , "gym_database").build()
    }


}