package com.example.boredapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
            tvActivityDescription.text = boredActivityUi.activity
            tvActivityType.text = boredActivityUi.type
            tvAccessibility.text = boredActivityUi.accessibility.toString()
            tvPrice.text = boredActivityUi.price.toString()
            tvParticipants.text = boredActivityUi.participants.toString()
        }
    }

    private fun setupListeners() {
        binding.buttonGetActivity.setOnClickListener {
            boredViewModel.getActivity(null)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}