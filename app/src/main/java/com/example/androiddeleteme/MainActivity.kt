package com.example.androiddeleteme

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private var isSelected = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spinner = findViewById(R.id.spinner)

        val spinnerArray = ArrayList<String>()
        spinnerArray.add("one")
        spinnerArray.add("two")
        spinnerArray.add("three")
        spinnerArray.add("four")
        spinnerArray.add("five")

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if(isSelected){
                    Log.i("Itemselected", spinnerArray[position])
                }
                isSelected = true
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }



        val spinnerArrayAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerArray)
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout
            .simple_spinner_dropdown_item);

        spinner.adapter = spinnerArrayAdapter
    }
}