package com.github.winstonrenatan.brodoraexplore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.github.winstonrenatan.brodoraexplore.databinding.FragmentHowtoplayBinding

class HowToPlay : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentHowtoplayBinding>(inflater,
            R.layout.fragment_howtoplay, container, false)

        return binding.root
    }
}