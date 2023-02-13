package com.example.gymhelper.layer.data.local.exercise

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ExerciseEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val planId : Long ,
    val exerciseName : String ,
    val exerciseSet : Int ,
    val exerciseRepeat : String
)
