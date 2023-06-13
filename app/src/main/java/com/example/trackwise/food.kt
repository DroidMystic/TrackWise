package com.example.trackwise

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.AutoCompleteTextView
import android.widget.Button
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

        val calculateButton = findViewById<MaterialButton>(R.id.resultsButton)
        calculateButton.setOnClickListener {
            val totalCalories = calculateTotalCalories()
            val intent = Intent(this, ResultsActivity::class.java)
            intent.putExtra("totalCalories", totalCalories)
            startActivity(intent)
        }

        val breakfastFoodWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val foodItem = s.toString()
                val calories = foodCalorieMap[foodItem]
                val editTextCaloriesBreakfast = findViewById<AutoCompleteTextView>(R.id.breakfastcalorie)
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
                val editTextCaloriesLunch = findViewById<AutoCompleteTextView>(R.id.lunchcalorie)
                editTextCaloriesLunch.setText(calories?.toString() ?: "")
            }
        }

        val dinnerFoodWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val foodItem = s.toString()
                val calories = foodCalorieMap[foodItem]
                val editTextCaloriesDinner = findViewById<AutoCompleteTextView>(R.id.dinnercalorie)

                editTextCaloriesDinner.setText(calories?.toString() ?: "")
            }
        }

        val editTextFoodBreakfast = findViewById<TextInputEditText>(R.id.breakfasthint)
        val editTextFoodLunch = findViewById<TextInputEditText>(R.id.lunchhint)
        val editTextFoodDinner = findViewById<TextInputEditText>(R.id.dinnerhint)
        editTextFoodBreakfast.addTextChangedListener(breakfastFoodWatcher)
        editTextFoodLunch.addTextChangedListener(lunchFoodWatcher)
        editTextFoodDinner.addTextChangedListener(dinnerFoodWatcher)



    }
    private fun calculateTotalCalories(): Int {
        val editTextFoodBreakfast = findViewById<AutoCompleteTextView>(R.id.breakfastcalorie)
        val breakfastCalories = editTextFoodBreakfast.text.toString().toIntOrNull() ?: 0
        val editTextFoodLunch = findViewById<AutoCompleteTextView>(R.id.lunchcalorie)
        val lunchCalories = editTextFoodLunch.text.toString().toIntOrNull() ?: 0
        val editTextFoodDinner = findViewById<AutoCompleteTextView>(R.id.dinnercalorie)
        val dinnerCalories = editTextFoodDinner.text.toString().toIntOrNull() ?: 0

        return breakfastCalories + lunchCalories + dinnerCalories
    }

}




