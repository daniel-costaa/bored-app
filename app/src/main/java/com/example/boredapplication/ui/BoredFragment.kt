package com.example.boredapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.boredapplication.data.models.ActivityStatus
import com.example.boredapplication.data.models.BoredActivityUi
import com.example.boredapplication.databinding.FragmentBoredBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class BoredFragment : Fragment() {
    private var _binding: FragmentBoredBinding? = null
    private val binding get() = _binding!!

    private val boredViewModel by viewModel<BoredViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBoredBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupListeners()
        setupObservers()
    }

    private fun setupObservers() {
        boredViewModel.currentActivity.observe(viewLifecycleOwner) {
            fillActivityData(it)
        }
    }

    private fun fillActivityData(boredActivityUi: BoredActivityUi) {
        with(binding) {
            textViewActivityNameValue.text = boredActivityUi.activity
            textViewActivityTypeValue.text = boredActivityUi.type
            textViewActivityAccessibilityValue.text = boredActivityUi.accessibility.toString()
            textViewActivityPriceValue.text = boredActivityUi.price.toString()
            textViewActivityParticipantsValue.text = boredActivityUi.participants.toString()
        }
    }

    private fun setupListeners() {
        with(binding) {
            buttonGetActivity.setOnClickListener {
                boredViewModel.getActivity(null)
                checkIfNeedsToEnableStartButton()
            }

            buttonStart.setOnClickListener {
                toggleButtons(isRunning = false)
                boredViewModel.setStartTime()
                boredViewModel.saveActivity()
            }

            buttonFinish.setOnClickListener {
                toggleButtons(isRunning = true)
                boredViewModel.updateExtraData(ActivityStatus.REALIZADA)
            }

            buttonGiveUp.setOnClickListener {
                toggleButtons(isRunning = true)
                boredViewModel.updateExtraData(ActivityStatus.DESISTENCIA)
            }
        }

    }

    private fun FragmentBoredBinding.checkIfNeedsToEnableStartButton() {
        if (!buttonStart.isEnabled) {
            buttonStart.isEnabled = true
        }
    }

    private fun FragmentBoredBinding.toggleButtons(isRunning: Boolean) {
        buttonStart.isVisible = isRunning
        buttonFinish.isVisible = !isRunning
        buttonGiveUp.isVisible = !isRunning
        buttonGetActivity.isEnabled = isRunning
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}