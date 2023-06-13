package com.example.trackwise

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class weightActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weight)

        val calculateButton = findViewById<Button>(R.id.calculateButton)
        calculateButton.setOnClickListener {
            val weightEditText = findViewById<EditText>(R.id.weightEditText)
            val weight = weightEditText.text.toString().toDoubleOrNull()
            val heightEditText = findViewById<EditText>(R.id.heightEditText)
            val height = heightEditText.text.toString().toDoubleOrNull()

            if (weight != null && height != null) {
                val bmi = calculateBMI(weight, height)
                val calorieSuggestion = suggestCalorieIntake(bmi)

                val bmiTextView = findViewById<TextView>(R.id.bmiTextView)
                bmiTextView.text = String.format("Your BMI Is: %.2f", bmi)
                val calorieSuggestionTextView = findViewById<TextView>(R.id.calorieSuggestionTextView)
                calorieSuggestionTextView.text = calorieSuggestion.toString()
            }
        }
    }

    private fun calculateBMI(weight: Double, height: Double): Double {
        val heightInMeter = height / 100.0
        return weight / (heightInMeter * heightInMeter)
    }

    private fun suggestCalorieIntake(bmi: Double): Int {
        return when {
            bmi < 18.5 -> 2500
            bmi < 25 -> 2000
            bmi < 30 -> 1800
            else -> 1500
        }
    }

}