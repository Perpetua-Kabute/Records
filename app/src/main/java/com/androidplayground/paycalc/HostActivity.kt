package com.androidplayground.paycalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class HostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host)
        Log.i("HostActivity", "Activity created")
    }
}