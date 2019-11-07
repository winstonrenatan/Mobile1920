package com.github.winstonrenatan.brodoraexplore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.github.winstonrenatan.brodoraexplore.databinding.FragmentEndingdisplayBinding
import timber.log.Timber

class EndingDisplay : Fragment() {

    val currentEnding: MyStoryLine.Scene = MyStoryLine.currentDisplayedEnding


    override fun onStart() {
        super.onStart()
        Timber.i("onStart called")
    }
    override fun onPause() {
        super.onPause()
        Timber.i("onPause called")
    }
    override fun onResume() {
        super.onResume()
        Timber.i("onResume called")
    }
    override fun onStop() {
        super.onStop()
        Timber.i("onStop called")
    }
    override fun onDestroy() {
        super.onDestroy()
        Timber.i("onDestroy called")
    }

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