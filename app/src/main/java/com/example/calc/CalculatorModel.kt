package com.example.calc

import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.cos
import kotlin.math.sqrt

class CalculatorModel {
    private var operand = 0.0f
    private var operandInWaiting = 0.0f
    private var operationInWaiting = ""

    fun setOperand(anOperand: Float) {
        operand = anOperand
    }

    fun executeOperation(anOperation: String): Float {
        executeOperationInWaiting()
        operationInWaiting = anOperation
        operandInWaiting = operand
        return this.operand
    }

    private fun executeOperationInWaiting() {
        if (operationInWaiting == "+") {
            operand += operandInWaiting
        } else if (operationInWaiting == "-") {
            operand = operandInWaiting - operand
        } else if (operationInWaiting == "×") {
            operand *= operandInWaiting
        } else if (operationInWaiting == "÷") {
            if (operand != 0.0f) {
                operand = operandInWaiting / operand
            }
        } else if (operationInWaiting == "^") {
            operand = operandInWaiting.pow(operand)
        } else if (operationInWaiting == "√") {
            operand = sqrt(operand)
        } else if (operationInWaiting == "sin") {
            operand = sin(operand)
        } else if (operationInWaiting == "cos") {
            operand = cos(operand)
        } else if (operationInWaiting == "+/-") {
            operand *= -1
        } else if (operationInWaiting == "1/x") {
            if (operand != 0.0f) {
                operand = 1 / operand
            }
        } else if (operationInWaiting == "10^x") {
            operandInWaiting = 10.0f
            operand = operandInWaiting.pow(operand)
        }
    }

    fun clearAll() {
        operand = 0.0f
        operandInWaiting = 0.0f
        operationInWaiting = ""
    }
}
