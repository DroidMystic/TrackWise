package com.example.trackwise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class ResultsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        val breakfastVitamins = intent.getStringExtra("breakfastVitamins")
        val breakfastCarbs = intent.getStringExtra("breakfastCarbs")
        val breakfastMinerals = intent.getStringExtra("breakfastMinerals")
        val breakfastFats = intent.getStringExtra("breakfastFats")
        val lunchVitamins = intent.getStringExtra("lunchVitamins")
        val lunchCarbs = intent.getStringExtra("lunchCarbs")
        val lunchMinerals = intent.getStringExtra("lunchMinerals")
        val lunchFats = intent.getStringExtra("lunchFats")
        val dinnerVitamins = intent.getStringExtra("dinnerVitamins")
        val dinnerCarbs = intent.getStringExtra("dinnerCarbs")
        val dinnerMinerals = intent.getStringExtra("dinnerMinerals")
        val dinnerFats = intent.getStringExtra("dinnerFats")

        val totalCaloriesTextView = findViewById<TextView>(R.id.totalCaloriesTextView)
        val totalCalories = intent.getIntExtra("totalCalories", 0)
        totalCaloriesTextView.text = "Total Calories: "+ totalCalories.toString()
        val vitaminsTextView = findViewById<TextView>(R.id.vitaminsTextView)
        vitaminsTextView.text = "Breakfast Vitamin: $breakfastVitamins, Lunch Vitamin: $lunchVitamins, Dinner Vitamin: $dinnerVitamins"
        val carbsTextView = findViewById<TextView>(R.id.carbsTextView)
        carbsTextView.text = "Breakfast Carbs: $breakfastCarbs, Lunch Carbs: $lunchCarbs, Dinner Carbs: $dinnerCarbs"
        val mineralsTextView = findViewById<TextView>(R.id.mineralsTextView)
        mineralsTextView.text = "Breakfast Minerals: $breakfastMinerals, Lunch Minerals: $lunchMinerals, Dinner Minerals: $dinnerMinerals"
        val fatsTextView = findViewById<TextView>(R.id.fatsTextView)
        fatsTextView.text = "Breakfast Fats: $breakfastFats, Lunch Fats: $lunchFats, Dinner Fats: $dinnerFats"




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
