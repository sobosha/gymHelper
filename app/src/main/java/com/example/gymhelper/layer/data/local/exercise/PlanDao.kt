package com.example.gymhelper.layer.data.local.exercise

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PlanDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlan(planEntity: PlanEntity) : Long

    @Query("DELETE FROM PlanEntity WHERE id = :planId")
    fun deletePlan(planId : Int)

    @Query("SELECT * FROM PlanEntity")
    fun getAllPlan(): Flow<List<PlanEntity>>
}