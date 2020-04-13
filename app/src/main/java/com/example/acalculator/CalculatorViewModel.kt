package com.example.acalculator

import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    private val calculatorLogic = CalculatorLogic()
    var display: String = ""

    private var listener: OnDisplayChanged? = null

    private fun notifyOnDisplayChanged() {
        listener?.onDisplayChanged(display)
    }
    fun registerListener(listener: OnDisplayChanged) {
        this.listener = listener
        listener.onDisplayChanged(display)
    }
    fun unregisterListener() {
        listener = null
    }

    fun onClickSymbol(symbol: String){
        display = calculatorLogic.insertSymbol(display, symbol)
        notifyOnDisplayChanged()
    }
    fun onClickEquals() {
        val result = calculatorLogic.performOperation(display)
        display = result.toString()
        notifyOnDisplayChanged()
    }
    fun onClickDelete() {
        display = calculatorLogic.deleteLast(display)
        notifyOnDisplayChanged()
    }
    fun onClickClearAll() {
        display = calculatorLogic.clear()
        notifyOnDisplayChanged()
    }
    fun onLastEquation() {
        display = calculatorLogic.getLastEquation()
        notifyOnDisplayChanged()
    }
    fun getOperations(): List<Operation> {
        return calculatorLogic.getOperations()
    }
    fun removeFromHistory(id: Int?) {
        calculatorLogic.removeFromHistoric(id)
        notifyOnDisplayChanged()
    }
}