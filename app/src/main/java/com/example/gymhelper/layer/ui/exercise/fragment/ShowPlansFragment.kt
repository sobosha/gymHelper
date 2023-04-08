package com.example.gymhelper.layer.ui.exercise.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.gymhelper.core.ui.collectOnFragment
import com.example.gymhelper.databinding.FragmentShowPlansBinding
import com.example.gymhelper.layer.ui.exercise.adapter.PlansAdapter
import com.example.gymhelper.layer.ui.exercise.viewModel.ShowPlansViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShowPlansFragment : Fragment() {

    lateinit var binding: FragmentShowPlansBinding
    private val showPlansViewModel: ShowPlansViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShowPlansBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val plansAdapter = PlansAdapter(){
        }
        binding.rvShowPlans.adapter = plansAdapter

        showPlansViewModel.plans.collectOnFragment(this){
            plansAdapter.submitList(it)
        }
    }
}