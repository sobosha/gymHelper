package com.example.gymhelper.layer.ui.exercise.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gymhelper.databinding.ItemRecExerciseBinding
import com.example.gymhelper.layer.ui.exercise.model.ExerciseView

class ExerciseAdapter(private val onItemClick: () -> Unit) :
    ListAdapter<ExerciseView, ExerciseAdapter.ExerciseViewHolder>(ExerciseDiffUtil) {

    inner class ExerciseViewHolder(private val binding: ItemRecExerciseBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener { onItemClick() }
        }
        fun bind(exercise: ExerciseView) {
            binding.exercise = exercise
            binding.tvExerciseSet.text = exercise.exerciseSet.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRecExerciseBinding.inflate(inflater, parent, false)
        return ExerciseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

object ExerciseDiffUtil : DiffUtil.ItemCallback<ExerciseView>() {
    override fun areItemsTheSame(oldItem: ExerciseView, newItem: ExerciseView): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ExerciseView, newItem: ExerciseView): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

}