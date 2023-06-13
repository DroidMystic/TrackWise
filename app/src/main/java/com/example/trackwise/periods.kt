package com.example.trackwise

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.DatePicker
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class periods : AppCompatActivity(),DatePickerDialog.OnDateSetListener {
    private var periodStartDate: Date? = null
    private var periodEndDate: Date? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_periods)

        val selectStartDateButton = findViewById<Button>(R.id.selectStartDateButton)
        selectStartDateButton.setOnClickListener {
            showDatePickerDialog(START_DATE_PICKER)
        }

        val selectEndDateButton = findViewById<Button>(R.id.selectEndDateButton)
        selectEndDateButton.setOnClickListener {
            showDatePickerDialog(END_DATE_PICKER)
        }

        val calculateButton = findViewById<Button>(R.id.calculateButton)
        calculateButton.setOnClickListener {
            if (periodStartDate != null && periodEndDate != null) {
                val periodDuration = calculatePeriodDuration(periodStartDate!!, periodEndDate!!)
                val periodDurationTextView = findViewById<TextView>(R.id.periodDurationTextView)
                periodDurationTextView.text = getString(R.string.period_duration, periodDuration)

                val symptoms = mutableListOf<String>()
                val headacheCheckBox = findViewById<CheckBox>(R.id.headacheCheckBox)
                if (headacheCheckBox.isChecked) {
                    symptoms.add("Headache")
                }
                val exhaustionCheckBox = findViewById<CheckBox>(R.id.exhaustionCheckBox)
                if (exhaustionCheckBox.isChecked) {
                    symptoms.add("Exhaustion")
                }
                val nauseaCheckBox = findViewById<CheckBox>(R.id.nauseaCheckBox)
                if (nauseaCheckBox.isChecked) {
                    symptoms.add("Nausea")
                }
                val crampsCheckBox = findViewById<CheckBox>(R.id.crampsCheckBox)
                if (crampsCheckBox.isChecked) {
                    symptoms.add("Cramps")
                }
                val vomitingCheckBox = findViewById<CheckBox>(R.id.vomitingCheckBox)
                if (vomitingCheckBox.isChecked) {
                    symptoms.add("Vomiting")
                }
                val bloatingCheckBox = findViewById<CheckBox>(R.id.bloatingCheckBox)
                if (bloatingCheckBox.isChecked) {
                    symptoms.add("Bloating")
                }

                val symptomsString = symptoms.joinToString(", ")
                val symptomsTextView = findViewById<TextView>(R.id.symptomsTextView)
                symptomsTextView.text = getString(R.string.symptoms_list, symptomsString)

                val fertilityDate = calculateFertilityDate(periodStartDate!!)
                val fertilityDateTextView = findViewById<TextView>(R.id.fertilityDateTextView)
                fertilityDateTextView.text = getString(R.string.fertility_date, fertilityDate)
            }
        }
    }


    private fun showDatePickerDialog(datePickerType: Int) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this,this, year, month, day)
        datePickerDialog.datePicker.tag = datePickerType
        datePickerDialog.show()

    }
    override fun onDateSet(view: DatePicker, year: Int, month: Int, dayOfMonth: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, dayOfMonth)

        val selectedDate = calendar.time

        when (view.tag as Int) {
            START_DATE_PICKER -> {
                periodStartDate = selectedDate
                val startDateTextView = findViewById<TextView>(R.id.startDateTextView)
                startDateTextView.text = formatDate(selectedDate)
            }
            END_DATE_PICKER -> {
                periodEndDate = selectedDate
                val endDateTextView = findViewById<TextView>(R.id.endDateTextView)
                endDateTextView.text = formatDate(selectedDate)
            }
        }
    }


    private fun calculatePeriodDuration(startDate: Date, endDate: Date): Int {
        val diffInMilliseconds = endDate.time - startDate.time
        val diffInDays = diffInMilliseconds / (24 * 60 * 60 * 1000)
        return diffInDays.toInt()
    }

    private fun calculateFertilityDate(startDate: Date): String {
        val calendar = Calendar.getInstance()
        calendar.time = startDate
        calendar.add(Calendar.DAY_OF_MONTH, 15)
        val fertilityDate = calendar.time
        return formatDate(fertilityDate)
    }

    private fun formatDate(date: Date): String {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return dateFormat.format(date)
    }

    companion object {
        private const val START_DATE_PICKER = 1
        private const val END_DATE_PICKER = 2
    }

}

