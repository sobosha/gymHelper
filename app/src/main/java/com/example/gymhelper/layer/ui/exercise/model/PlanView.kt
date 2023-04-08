package com.example.gymhelper.layer.ui.exercise.model

import com.example.gymhelper.layer.data.local.exercise.PlanEntity

data class PlanView(
    val id: Int = 0,
    val planName: String,
    val planRestTime: Int,
    val isRestTimeTypeSecond: Boolean
) {
    fun toPlanEntity() = PlanEntity(
        planName = planName,
        restTimeBetweenExercise = planRestTime * (if (!isRestTimeTypeSecond) 60 else 1)
    )
}

fun PlanEntity.toPlanView() = PlanView(
    planName = planName ,
    id = id ,
    planRestTime = restTimeBetweenExercise ,
    isRestTimeTypeSecond = true
)