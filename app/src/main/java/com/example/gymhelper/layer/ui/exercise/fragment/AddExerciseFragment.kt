package com.example.gymhelper.layer.ui.exercise.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.gymhelper.R
import com.example.gymhelper.core.ui.collectOnFragment
import com.example.gymhelper.databinding.FragmentAddExerciseBinding
import com.example.gymhelper.layer.ui.exercise.adapter.ExerciseAdapter
import com.example.gymhelper.layer.ui.exercise.model.ExerciseView
import com.example.gymhelper.layer.ui.exercise.viewModel.AddExerciseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddExerciseFragment : Fragment() {

    private lateinit var binding: FragmentAddExerciseBinding
    private val exerciseViewModel: AddExerciseViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddExerciseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initArgument()
        val exerciseAdapter = ExerciseAdapter {

        }
        binding.rvExerciseAddExercise.adapter = exerciseAdapter

        exerciseViewModel.exercises.collectOnFragment(this) {
            exerciseAdapter.submitList(it)
        }
        binding.tvAddExerciseAddExercise.setOnClickListener {
            exerciseViewModel.addExercise(
                ExerciseView(
                    binding.tieExerciseNameAddPlan.text.toString(),
                    binding.tieExerciseSetAddPlan.text.toString().toIntOrNull() ?: 0,
                    binding.tieExerciseRepeatAddPlan.text.toString()
                )
            )
        }
    }

    private fun initArgument() {
        val args: AddExerciseFragmentArgs by navArgs()
        if (args.planId >= 0) {
            exerciseViewModel.setPlanId(planId = args.planId)
        } else {
            Toast.makeText(requireContext(), getString(R.string.msg_error), Toast.LENGTH_SHORT)
                .show()
        }
    }

}