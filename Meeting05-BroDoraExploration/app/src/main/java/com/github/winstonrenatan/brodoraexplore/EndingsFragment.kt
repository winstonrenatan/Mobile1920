package com.github.winstonrenatan.brodoraexplore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.github.winstonrenatan.brodoraexplore.databinding.FragmentEndingsBinding

class EndingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentEndingsBinding>(inflater,
            R.layout.fragment_endings, container, false)

        // Ending Buttons Listeners...
        binding.endingOneButton.setOnClickListener {
            MyStoryLine.currentDisplayedEnding = MyStoryLine.scenes[6]
            it.findNavController().navigate(R.id.action_endingsFragment_to_endingDisplay)
        }
        binding.endingTwoButton.setOnClickListener {
            MyStoryLine.currentDisplayedEnding = MyStoryLine.scenes[7]
            it.findNavController().navigate(R.id.action_endingsFragment_to_endingDisplay)
        }
        binding.endingThreeButton.setOnClickListener {
            MyStoryLine.currentDisplayedEnding = MyStoryLine.scenes[8]
            it.findNavController().navigate(R.id.action_endingsFragment_to_endingDisplay)
        }

        // Enabling/disabling buttons
        if (MyStoryLine.ending1) binding.endingOneButton.isEnabled = true
        if (MyStoryLine.ending2) binding.endingTwoButton.isEnabled = true
        if (MyStoryLine.ending3) binding.endingThreeButton.isEnabled = true

        return binding.root
    }
}