package com.example.boredapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.boredapplication.R
import com.example.boredapplication.data.repositories.BoredRepository
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val teste by inject<BoredRepository>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       lifecycleScope.launchWhenStarted {
           teste.getRandomActivity(null)
           println()
       }
    }
}