package com.example.countrysearch.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.countrysearch.R
import com.example.countrysearch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)
    }
}