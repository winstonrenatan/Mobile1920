package com.github.winstonrenatan.lifecycleandroid

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Help: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.help)
        Toast.makeText(this, "We are in help!", Toast.LENGTH_SHORT).show()
    }
}