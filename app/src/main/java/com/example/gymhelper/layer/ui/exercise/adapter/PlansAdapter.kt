package com.example.gymhelper.layer.ui.exercise.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gymhelper.databinding.ItemRecPlanBinding
import com.example.gymhelper.layer.ui.exercise.model.PlanView

class PlansAdapter(private val onClickItem : () -> Unit) : ListAdapter<PlanView , PlansAdapter.PlanViewHolder>(PlansDiffUtil){

    inner class PlanViewHolder(private val binding : ItemRecPlanBinding):
        RecyclerView.ViewHolder(binding.root){
            init {
                binding.root.setOnClickListener { onClickItem()}
            }

            fun bind(planView : PlanView){
                binding.plan = planView
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRecPlanBinding.inflate(inflater , parent , false)
        return PlanViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlanViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


}

object PlansDiffUtil: DiffUtil.ItemCallback<PlanView>(){
    override fun areItemsTheSame(oldItem: PlanView, newItem: PlanView): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: PlanView, newItem: PlanView): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

}