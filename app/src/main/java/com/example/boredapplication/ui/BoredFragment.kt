package com.example.boredapplication.ui

import android.os.Bundle
import android.view.*
import android.widget.PopupMenu
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.boredapplication.R
import com.example.boredapplication.data.models.ActivityStatus
import com.example.boredapplication.data.models.ActivityTypes
import com.example.boredapplication.data.models.BoredActivityUi
import com.example.boredapplication.databinding.FragmentBoredBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class BoredFragment : Fragment(), PopupMenu.OnMenuItemClickListener {
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
                boredViewModel.getActivity()
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

            menuType.setOnClickListener {
                PopupMenu(requireContext(), it).apply {
                    setOnMenuItemClickListener(this@BoredFragment)
                    inflate(R.menu.activity_types_menu)
                    show()
                }
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

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        item?.let {
            val type = when (it.itemId) {
                R.id.education -> ActivityTypes.EDUCATIONAL
                R.id.recreational -> ActivityTypes.RECREATIONAL
                R.id.social -> ActivityTypes.SOCIAL
                R.id.diy -> ActivityTypes.DIY
                R.id.charity -> ActivityTypes.CHARITY
                R.id.cooking -> ActivityTypes.COOKING
                R.id.relaxation -> ActivityTypes.RELAXTION
                R.id.music -> ActivityTypes.MUSIC
                R.id.busywork -> ActivityTypes.BUSYWORK
                else -> null
            }

            binding.menuType.text = item.title
            boredViewModel.setActivityType(type)
        }

        return true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}