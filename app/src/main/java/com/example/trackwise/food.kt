package com.example.trackwise

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import org.w3c.dom.Text

class food : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        val foodCalorieMap = mapOf(
            "Egg" to 80,
            "Bread" to 100,
            "Milk" to 120,
            "Vegetable Biryani" to 350,
            "Chickpea Curry" to 235,
            "Palak Paneer" to 260,
            "Vegetable Curry" to 120,
            "Raita" to 50,
            "Paneer Curry" to 160
            // Add more food items and their calorie values as needed
        )

        val calculateButton = findViewById<Button>(R.id.calculateButton)
        calculateButton.setOnClickListener {
            val totalCalories = calculateTotalCalories()
            val breakfastVitaminsEditText = findViewById<EditText>(R.id.breakfastVitaminsEditText)
            val breakfastVitamins = breakfastVitaminsEditText.text.toString()
            val breakfastCarbsEditText = findViewById<EditText>(R.id.breakfastCarbsEditText)
            val breakfastCarbs = breakfastCarbsEditText.text.toString()
            val breakfastMineralsEditText = findViewById<EditText>(R.id.breakfastMineralsEditText)
            val breakfastMinerals = breakfastMineralsEditText.text.toString()
            val breakfastFatsEditText = findViewById<EditText>(R.id.breakfastFatsEditText)
            val breakfastFats = breakfastFatsEditText.text.toString()
            val lunchVitaminsEditText = findViewById<EditText>(R.id.lunchVitaminsEditText)
            val lunchVitamins = lunchVitaminsEditText.text.toString()
            val lunchCarbsEditText = findViewById<EditText>(R.id.lunchCarbsEditText)
            val lunchCarbs = lunchCarbsEditText.text.toString()
            val lunchMineralsEditText = findViewById<EditText>(R.id.lunchMineralsEditText)
            val lunchMinerals = lunchMineralsEditText.text.toString()
            val lunchFatsEditText = findViewById<EditText>(R.id.lunchFatsEditText)
            val lunchFats = lunchFatsEditText.text.toString()
            val dinnerVitaminsEditText = findViewById<EditText>(R.id.dinnerVitaminsEditText)
            val dinnerVitamins = dinnerVitaminsEditText.text.toString()
            val dinnerCarbsEditText = findViewById<EditText>(R.id.dinnerCarbsEditText)
            val dinnerCarbs = dinnerCarbsEditText.text.toString()
            val dinnerMineralsEditText = findViewById<EditText>(R.id.dinnerMineralsEditText)
            val dinnerMinerals = dinnerMineralsEditText.text.toString()
            val dinnerFatsEditText = findViewById<EditText>(R.id.dinnerFatsEditText)
            val dinnerFats = dinnerFatsEditText.text.toString()

            val intent = Intent(this, ResultsActivity::class.java)
            intent.putExtra("totalCalories", totalCalories)
            intent.putExtra("breakfastVitamins", breakfastVitamins)
            intent.putExtra("breakfastCarbs", breakfastCarbs)
            intent.putExtra("breakfastMinerals", breakfastMinerals)
            intent.putExtra("breakfastFats", breakfastFats)
            intent.putExtra("lunchVitamins", lunchVitamins)
            intent.putExtra("lunchCarbs", lunchCarbs)
            intent.putExtra("lunchMinerals", lunchMinerals)
            intent.putExtra("lunchFats", lunchFats)
            intent.putExtra("dinnerVitamins", dinnerVitamins)
            intent.putExtra("dinnerCarbs", dinnerCarbs)
            intent.putExtra("dinnerMinerals", dinnerMinerals)
            intent.putExtra("dinnerFats", dinnerFats)
            startActivity(intent)
        }

        val breakfastFoodWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val foodItem = s.toString()
                val calories = foodCalorieMap[foodItem]
                val editTextCaloriesBreakfast = findViewById<EditText>(R.id.breakfastCaloriesEditText)
                editTextCaloriesBreakfast.setText(calories?.toString() ?: "")
            }
        }

        val lunchFoodWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            @SuppressLint("WrongViewCast")
            override fun afterTextChanged(s: Editable?) {
                val foodItem = s.toString()
                val calories = foodCalorieMap[foodItem]
                val editTextCaloriesLunch = findViewById<EditText>(R.id.lunchCaloriesEditText)
                editTextCaloriesLunch.setText(calories?.toString() ?: "")
            }
        }

        val dinnerFoodWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val foodItem = s.toString()
                val calories = foodCalorieMap[foodItem]
                val editTextCaloriesDinner = findViewById<EditText>(R.id.dinnerCaloriesEditText)

                editTextCaloriesDinner.setText(calories?.toString() ?: "")
            }
        }

        val editTextFoodBreakfast = findViewById<EditText>(R.id.breakfastFoodEditText)
        val editTextFoodLunch = findViewById<EditText>(R.id.lunchFoodEditText)
        val editTextFoodDinner = findViewById<EditText>(R.id.dinnerFoodEditText)
        editTextFoodBreakfast.addTextChangedListener(breakfastFoodWatcher)
        editTextFoodLunch.addTextChangedListener(lunchFoodWatcher)
        editTextFoodDinner.addTextChangedListener(dinnerFoodWatcher)



    }
    private fun calculateTotalCalories(): Int {
        val editTextFoodBreakfast = findViewById<EditText>(R.id.breakfastCaloriesEditText)
        val breakfastCalories = editTextFoodBreakfast.text.toString().toIntOrNull() ?: 0
        val editTextFoodLunch = findViewById<EditText>(R.id.lunchCaloriesEditText)
        val lunchCalories = editTextFoodLunch.text.toString().toIntOrNull() ?: 0
        val editTextFoodDinner = findViewById<EditText>(R.id.dinnerCaloriesEditText)
        val dinnerCalories = editTextFoodDinner.text.toString().toIntOrNull() ?: 0

        return breakfastCalories + lunchCalories + dinnerCalories
    }

}




