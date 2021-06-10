package com.dyinlabz.tiptime

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dyinlabz.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener { calculateTip() }


    }

    fun calculateTip(){
        val stringInField = binding.costOfService.text.toString()
        val cost = stringInField.toDouble()

        val selectedId = binding.tipOptions.checkedRadioButtonId

        val tipPercentage = when (selectedId) {
            R.id.tip_twenty_percent -> 0.20
            R.id.tip_eighteen_percent -> 0.18
            else -> 0.15
        }

        var tip = tipPercentage * cost

        val roundUp = binding.roundUpSwitch.isChecked

        if (roundUp){
            kotlin.math.ceil(tip)
        }

        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }

}