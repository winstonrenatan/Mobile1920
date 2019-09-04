package com.github.winstonrenatan.lifecycleandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {

    val TAG="Main Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG,"In OnCreate")
        val about_us=findViewById<Button>(R.id.about_us)
        val help=findViewById<Button>(R.id.help_me)
        about_us.setOnClickListener {
            val m=Intent(this,AboutUs::class.java)
            startActivity(m)
        }
        help.setOnClickListener {
            val n=Intent(this,Help::class.java)
            startActivity(n)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"In OnStart")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"In OnStop")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"In OnPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"In OnDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"In OnRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"In OnResume")
    }
}
