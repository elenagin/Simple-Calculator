package com.example.calc

import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.cos
import kotlin.math.sqrt

class CalculatorModel {
    private var operand = 0.0f
    private var operandInWaiting = 0.0f
    private var operatorInWaiting = ""
    private var calculatorMemory = 0.0f

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
        executeMemoryOperatorInWaiting()
        operatorInWaiting = anOperation
        operandInWaiting = operand
        return this.operand
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
        }
    }


    /* Private function executes waiting memory operation depending on the waiting operator
    * @Elena Ginebra
    * */
    private fun executeMemoryOperatorInWaiting() {
        if (operatorInWaiting == "MC") {
            operand = 7f
        } else if (operatorInWaiting == "MR") {
            operand = 8f
        } else if (operatorInWaiting == "MS") {
            operand = 20f
        } else if (operatorInWaiting == "M+") {
            operand = 8111f
        } else if (operatorInWaiting == "M-") {
            operand = 3333f
        }
    }


    /* Function clears all operands, operators and memory
    * @Elena Ginebra
    * */
    fun clearAll() {
        operand = 0.0f
        operandInWaiting = 0.0f
        operatorInWaiting = ""
    }
}
