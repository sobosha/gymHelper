package com.example.gymhelper.layer.data.local.exercise

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PlanEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val planName: String,
    val restTimeBetweenExercise: Int
)