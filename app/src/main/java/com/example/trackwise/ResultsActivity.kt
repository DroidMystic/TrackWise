package com.example.trackwise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class ResultsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        val totalCalories = intent.getIntExtra("totalCalories", 0)

        val totalCaloriesTextView = findViewById<TextView>(R.id.totalCaloriesTextView)
        totalCaloriesTextView.text = totalCalories.toString()

        val comparisonResult = when {
            totalCalories < 2000 -> {
                val additionalRecommendation = "Consider adding nutritious items like dry fruits to your diet."
                "You consumed fewer calories than recommended. $additionalRecommendation"
            }
            totalCalories > 2000 -> "You consumed more calories than recommended."
            else -> "You consumed the recommended amount of calories."
        }

        val comparisonResultTextView = findViewById<TextView>(R.id.comparisonResultTextView)
        comparisonResultTextView.text = comparisonResult

    }

}
