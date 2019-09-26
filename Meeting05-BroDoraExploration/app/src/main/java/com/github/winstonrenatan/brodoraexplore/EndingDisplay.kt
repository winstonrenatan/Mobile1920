package com.github.winstonrenatan.brodoraexplore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.github.winstonrenatan.brodoraexplore.databinding.FragmentEndingdisplayBinding

class EndingDisplay : Fragment() {

    val currentEnding: MyStoryLine.Scene = MyStoryLine.currentDisplayedEnding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentEndingdisplayBinding>(inflater,
            R.layout.fragment_endingdisplay, container, false)

        binding.endingDisplay = this

        return binding.root
    }
}