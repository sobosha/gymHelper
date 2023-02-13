package com.example.gymhelper.layer.ui.exercise.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.gymhelper.core.ui.collectOnFragment
import com.example.gymhelper.core.ui.safeNavigate
import com.example.gymhelper.databinding.FragmentAddPlanBinding
import com.example.gymhelper.layer.ui.exercise.model.PlanView
import com.example.gymhelper.layer.ui.exercise.viewModel.AddPlanViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddPlanFragment : Fragment() {
    private val addPlanViewModel: AddPlanViewModel by viewModels()
    private lateinit var binding: FragmentAddPlanBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddPlanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            rbSecondAddPlan.isChecked = true
            tvSaveAddPlan.setOnClickListener {
                addPlanViewModel.addPlan(
                    PlanView(
                        planName = tiePlanNameAddPlan.text.toString(),
                        planRestTime = tieRestAddPlan.text.toString().toIntOrNull() ?: 0 ,
                        isRestTimeTypeSecond = rbSecondAddPlan.isChecked
                    )
                ).collectOnFragment(this@AddPlanFragment){
                    safeNavigate(AddPlanFragmentDirections.actionAddPlanFragmentToAddExerciseFragment(it))
                }
            }
        }

        addPlanViewModel.message.collectOnFragment(this){
            Toast.makeText(requireContext(), requireContext().getString(it), Toast.LENGTH_SHORT).show()
        }
    }
}