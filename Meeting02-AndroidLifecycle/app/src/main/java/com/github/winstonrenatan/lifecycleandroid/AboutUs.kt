package com.github.winstonrenatan.lifecycleandroid

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AboutUs: AppCompatActivity() {
    val TAG="About Us"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_us)
        Log.d(TAG, "Inside onCreate")
        Toast.makeText(this, "We are in about us!", Toast.LENGTH_SHORT).show()
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