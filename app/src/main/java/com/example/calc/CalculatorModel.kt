package com.example.calc

import android.widget.Toast
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.cos
import kotlin.math.sqrt

class CalculatorModel {
    private var operand = 0.0f
    private var operandInWaiting = 0.0f
    private var operatorInWaiting = ""
    var calculatorMemory = 0.0f

    /* Function receives Float from controller and sets operand
    * @Elena Ginebra
    * */
    fun setOperand(anOperand: Float) {
        operand = anOperand
    }

    /* Function receives String from controller, executes memory operations
    * @Elena Ginebra
    * */
    fun executeOperation(anOperation: String): Float {
        executeOperatorInWaiting()
        operatorInWaiting = anOperation
        operandInWaiting = operand
        return this.operand
    }

    /* Function receives String from controller, executes memory operations
    * @Elena Ginebra
    * */
    fun executeMemoryOperation(anOperation: String): Float {
        operatorInWaiting = anOperation
        operandInWaiting = operand
        executeMemoryOperatorInWaiting()
        println("Just before returning memory, memory=" + this.calculatorMemory)
        return this.calculatorMemory
    }

    /* Private function executes waiting Operation depending on the waiting operator
    * @Elena Ginebra
    * */
    private fun executeOperatorInWaiting() {
        if (operatorInWaiting == "+") {
            operand += operandInWaiting
        } else if (operatorInWaiting == "-") {
            operand = operandInWaiting - operand
        } else if (operatorInWaiting == "×") {
            operand *= operandInWaiting
        } else if (operatorInWaiting == "÷") {
            if (operand != 0.0f) {
                operand = operandInWaiting / operand
            }
        } else if (operatorInWaiting == "^") {
            operand = operandInWaiting.pow(operand)
        } else if (operatorInWaiting == "√") {
            operand = sqrt(operand)
        } else if (operatorInWaiting == "sin") {
            operand = sin(operand)
        } else if (operatorInWaiting == "cos") {
            operand = cos(operand)
        } else if (operatorInWaiting == "+/-") {
            operand *= -1
        } else if (operatorInWaiting == "1/x") {
            if (operand != 0.0f) {
                operand = 1 / operand
            }
        } else if (operatorInWaiting == "10^x") {
            operandInWaiting = 10.0f
            operand = operandInWaiting.pow(operand)
        } else if (operatorInWaiting == "MR") {
            operand = calculatorMemory
        }
    }


    /* Private function executes waiting memory operation depending on the waiting operator
    * @Elena Ginebra
    * */
    private fun executeMemoryOperatorInWaiting() {
        println("INSIDE executeMemoryOperatorInWaiting")
        if (operatorInWaiting == "MC") {
            calculatorMemory = 0.0f
        } else if (operatorInWaiting == "MS") {
            calculatorMemory = operand
            println(calculatorMemory)
        } else if (operatorInWaiting == "M+") {
            calculatorMemory += operand
        } else if (operatorInWaiting == "M-") {
            calculatorMemory = calculatorMemory - operand
        } else if (operatorInWaiting == "MR") {
            operand = calculatorMemory
        }
    }


    /* Function clears all operands, operators and memory
    * @Elena Ginebra
    * */
    fun clearAll() {
        operand = 0.0f
        operandInWaiting = 0.0f
        operatorInWaiting = ""
        calculatorMemory = 0.0f
    }
}
