package com.example.trackwise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class allergy : AppCompatActivity() {
    private val allergies = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_allergy)

        val addAllergyButton =findViewById<Button>(R.id.addAllergyButton)
        addAllergyButton.setOnClickListener {
            val allergyEditText = findViewById<EditText>(R.id.allergyEditText)
            val allergy = allergyEditText.text.toString().trim()
            if (allergy.isNotEmpty()) {
                allergies.add(allergy)
                allergyEditText.text.clear()
                updateAllergyCount()
                updateAllergyList()
            }
        }

        val clearAllergiesButton = findViewById<Button>(R.id.clearAllergiesButton)
        clearAllergiesButton.setOnClickListener {
            allergies.clear()
            updateAllergyCount()
            updateAllergyList()
        }
    }

    private fun updateAllergyCount() {
        val totalCount = allergies.size
        val allergyCountTextView = findViewById<TextView>(R.id.allergyListTextView)
        allergyCountTextView.text = totalCount.toString()
    }

    private fun updateAllergyList() {
        val allergyListTextView = findViewById<TextView>(R.id.allergyListTextView)
        allergyListTextView.text = allergies.joinToString("\n")
    }

}
