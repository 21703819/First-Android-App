package com.example.acalculator

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorLogic {
    private val storage = ListStorage.gatInstance()
    private var lastEquation = "0"

    fun insertSymbol(display:String, symbol: String): String {
        return if(display.isEmpty() && symbol == "0") symbol else display + symbol
    }

    fun performOperation(expression:String):Double {
        val expressionBuilder = ExpressionBuilder(expression).build()
        val result = expressionBuilder.evaluate()
        val operation = Operation(expression, result)
        lastEquation = "$expression = $result"
        CoroutineScope(Dispatchers.IO).launch {
            storage.insert(operation)
        }
        return result
    }
    fun deleteLast(display: String):String {
        var newDisplay = display
        val length = newDisplay.length
        if (length > 1) {
            val newText = newDisplay.subSequence(0, length - 1)
            newDisplay = newText as String
        } else {
            newDisplay = "0"
        }
        return newDisplay
    }
    fun clear(): String {
        return "0"
    }
    fun getLastEquation(): String {
        return lastEquation
    }
    fun getOperations(): List<Operation> {
        return storage.getAll()
    }
    fun removeFromHistoric(id: Int?) {
        storage.delete(id)
    }
}