package com.github.winstonrenatan.constraintsproject

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var selectedID = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        restartGame()
    }

    private fun setOnClick (view: View) {
        if(view.id == selectedID) {
            // set to big star
            view.setBackgroundResource(android.R.drawable.btn_star_big_on)
            val builder = AlertDialog.Builder(view.context)
            builder.setTitle("CONGRATS YOU WIN!")
            builder.setMessage("Press the star again to restart game.")
            builder.setPositiveButton("OK"){dialogInterface, which ->
                Toast.makeText(view.context, "Press the star to restart the game.", Toast.LENGTH_SHORT).show()
            }
            builder.create().show()
            view.setOnClickListener{
                restartGame()
            }

        } else {
            // set to red x
            view.setBackgroundResource(android.R.drawable.ic_delete)
        }
    }

    private fun restartGame() {
        val boxOneText = findViewById<TextView>(R.id.box_one_text)
        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
        val boxFourText = findViewById<TextView>(R.id.box_four_text)
        val boxFiveText = findViewById<TextView>(R.id.box_five_text)
        val boxSixText = findViewById<TextView>(R.id.box_six_text)
        val boxSevenText = findViewById<TextView>(R.id.box_seven_text)
        val boxEightText = findViewById<TextView>(R.id.box_eight_text)
        val boxNineText = findViewById<TextView>(R.id.box_nine_text)
        val boxTenText = findViewById<TextView>(R.id.box_ten_text)

        val boxIDList: List<Int> = listOf(
            R.id.box_one_text,
            R.id.box_two_text,
            R.id.box_three_text,
            R.id.box_four_text,
            R.id.box_five_text,
            R.id.box_six_text,
            R.id.box_seven_text,
            R.id.box_eight_text,
            R.id.box_nine_text,
            R.id.box_ten_text
        )
        selectedID = boxIDList[Random.nextInt(0,boxIDList.size)]

        val clickableViews: List<View> =
            listOf(boxOneText,boxTwoText,boxThreeText,boxFourText,boxFiveText,
                boxSixText,boxSevenText,boxEightText,boxNineText,boxTenText)

        for (item in clickableViews) {
            item.setOnClickListener{
                setOnClick(it)
            }
            item.setBackgroundColor(Color.WHITE)
        }
    }
}
