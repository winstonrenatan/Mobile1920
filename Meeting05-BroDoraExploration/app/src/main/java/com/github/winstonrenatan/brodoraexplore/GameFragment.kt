package com.github.winstonrenatan.brodoraexplore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.github.winstonrenatan.brodoraexplore.databinding.FragmentGameBinding
import com.github.winstonrenatan.brodoraexplore.MyStoryLine.Scene

class GameFragment : Fragment() {

    // Variables
    private val scenes = MyStoryLine.scenes
    lateinit var currentScene: Scene
    private var selectedActionId: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(
            inflater, R.layout.fragment_game, container, false)

        // This is IMPORTANT! without this, "@{}" things in [fragment_game.sml] won't work.
        currentScene = scenes[0]

        // Bind this fragment class to the layout
        binding.scene = this

        // Listener for action button
        binding.actionButton.setOnClickListener {

            if(binding.actions.checkedRadioButtonId != -1) {

                when (binding.actions.checkedRadioButtonId) {
                    binding.actionOne.id -> selectedActionId = 0
                    binding.actionTwo.id -> selectedActionId = 1
                }

                when (currentScene) {
                    //Introduction
                    scenes[0] -> {
                        when(selectedActionId) {
                            0 -> currentScene = scenes[1]
                            1 -> currentScene = scenes[2]
                        }
                    }
                    //Parking at the Sky (with Boots)
                    scenes[1] -> {
                        when(selectedActionId) {
                            0 -> currentScene = scenes[3]
                            1 -> currentScene = scenes[4]
                        }
                    }
                    //Parking at the Sky (with Swiper)
                    scenes[2] -> {
                        when(selectedActionId) {
                            0 -> currentScene = scenes[4]
                            1 -> currentScene = scenes[5]
                        }
                    }
                    //Enter Building with Money
                    scenes[3] -> {
                        when(selectedActionId) {
                            0 -> currentScene = scenes[8]
                            1 -> currentScene = scenes[6]
                        }
                    }
                    //Enter Building with no Money
                    scenes[4] -> {
                        when(selectedActionId) {
                            0 -> currentScene = scenes[7]
                            1 -> currentScene = scenes[7]
                        }
                    }
                    //Enter Building Alone
                    scenes[5] -> {
                        when(selectedActionId) {
                            0 -> currentScene = scenes[8]
                            1 -> currentScene = scenes[8]
                        }
                    }
                    //Young and Rich
                    scenes[6] -> {
                        MyStoryLine.ending1 = true
                        ending()
                    }
                    //Young and Broke
                    scenes[7] -> {
                        MyStoryLine.ending2 = true
                        ending()
                    }
                    //Final Life
                    scenes[8] -> {
                        MyStoryLine.ending3 = true
                        ending()
                    }
                }

                // Disabling options if choice == "" and enabling them if not
                if (currentScene.actions[0] == "") binding.actionOne.isEnabled = false else binding.actionOne.isEnabled = true
                if (currentScene.actions[1] == "") binding.actionTwo.isEnabled = false else binding.actionTwo.isEnabled = true

                binding.actions.clearCheck()
                binding.scrollView.fullScroll(ScrollView.FOCUS_UP)
                binding.invalidateAll()
            } else {
                Toast.makeText(this.activity, "Don't just stand quiet!", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

    private fun ending() {
        when(selectedActionId) {
            0 -> this.activity!!.onBackPressed()
            1 -> currentScene = scenes[0]
        }
    }

}
