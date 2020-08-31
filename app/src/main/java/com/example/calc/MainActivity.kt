package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.lang.Error

class MainActivity : AppCompatActivity() {
    private lateinit var display: TextView
    private var flagFirstDigitDisplay = false
    private var flagDecimalPoint = false
    private var res = 0.0f
    private val brainCalculator = CalculatorModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        display = findViewById(R.id.display)
    }

    fun nothing(view: View) {}

    fun numPressed(aButton: View) {
        var pressedButton = (aButton as Button).text

        if (pressedButton == "π") {
            pressedButton = "3.14159"
            flagDecimalPoint = true
        }

        if (flagFirstDigitDisplay) {
            if (!flagDecimalPoint) {
                if (pressedButton == ".") {
                    display.append(pressedButton)
                    flagDecimalPoint = true
                } else {
                    display.append(pressedButton)
                }
            } else {
                if (pressedButton != ".") {
                    display.append(pressedButton)
                }
            }
        } else {
            if (pressedButton != "0" && pressedButton != ".") {
                flagFirstDigitDisplay = true
                display.text = pressedButton
            } else if (pressedButton == ".") {
                display.text = "0."
                flagFirstDigitDisplay = true
                flagDecimalPoint = true
            }
        }
    }

    fun operatorPressed(aButton: View) {
        if (flagFirstDigitDisplay) {
            brainCalculator.setOperand(display.text.toString().toFloat())
            flagFirstDigitDisplay = false
        }
        res = brainCalculator.executeOperation((aButton as Button).text.toString())
        flagDecimalPoint = false

        try {
            display.text = res.toString()
        } catch (e: Error) {
            display.text = "Error"
        }
    }

    fun clear(aButton: View) {
        brainCalculator.clearAll()
        display.text = "0"
        flagFirstDigitDisplay = false
        flagDecimalPoint = false
    }

}