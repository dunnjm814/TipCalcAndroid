package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    // lateinit keyword promises your code will initialize the variable before using it
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // initializes binding object which we will access Views from activity_main.xml
        binding = ActivityMainBinding.inflate(layoutInflater)
        // Set content view of activity. Instead of passing ID resource of layout, R.layout.activity_main
        // specify root of app view hierarchy to binding root
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener{ calculateTip() }
    }

    private fun calculateTip() {
        // grab text from EditText view, since this is an Editable, we must cast it into a string()
        val stringInTextField = binding.costOfService.text.toString()
        // convert string into a decimal number.
        val cost = stringInTextField.toDouble()
        if (cost == null) {
            binding.tipResult.text = ""
            return
        }
        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }
        // use of var here instead of val because we may need to round up if switch is checked true
        var tip = tipPercentage * cost
        if(binding.roundUpSwitch.isChecked){
            tip = kotlin.math.ceil(tip)
        }
        // formatting the tip double into a currency
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}