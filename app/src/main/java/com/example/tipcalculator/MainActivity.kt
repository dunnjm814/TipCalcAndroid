package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    // lateinit keyword promises your code will initialize the variable before using it
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // initializes binding object which we will access Views from activity_main.xml
        binding = ActivityMainBinding.inflate(layoutInflater)
        // Set content view of activity. Instead of passing ID resource of layout, R.layout.activity_main
        // specify root of app view heirarchy to binding root
        setContentView(binding.root)
    }
}