package com.github.winstonrenatan.coinflipper

import android.animation.ObjectAnimator
import android.media.Image
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import androidx.core.os.HandlerCompat.postDelayed
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T

class MainActivity : AppCompatActivity() {

    lateinit var flipCoin: ImageView
    lateinit var flipResult: TextView
    lateinit var flipButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        flipCoin=findViewById(R.id.coin) as ImageView
        flipResult=findViewById(R.id.head_tail) as TextView
        flipButton=findViewById(R.id.flip_button) as Button

        val soundeffect = MediaPlayer.create(this, R.raw.coinsound)

        flipButton.setOnClickListener{
            flipCoin()
            soundeffect.start()
            Toast.makeText(this, "Coin Flipped!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun flipCoin() {
        val randomInt= Random().nextInt(2)+1
        if (randomInt==1) {
            flipResult.text="Head!"
            flipCoin.setImageResource(R.drawable.coin_head)
        }
        else {
            flipResult.text="Tail!"
            flipCoin.setImageResource(R.drawable.coin_tail)
        }
        val rotateCoin = RotateAnimation(0f, 360f,
            RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f)
        rotateCoin.setDuration(1750)
        flipCoin.startAnimation(rotateCoin)
    }
}
