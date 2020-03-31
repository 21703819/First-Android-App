package com.example.acalculator

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import butterknife.OnClick
import kotlinx.android.synthetic.main.fragment_calculator.*
import net.objecthunter.exp4j.ExpressionBuilder


class CalculatorFragment : Fragment() {

    private val TAG = CalculatorFragment::class.java.simpleName

    private var lastEquation = "0"

    var operations = ArrayList<Operation>()

    var operations_portrait = ArrayList<Operation>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val orientation =text_visor.tag.toString()
        Log.i(TAG, orientation)
        if(orientation != "landscape") {
            button_last_equation.setOnClickListener{onClickText(lastEquation)}
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_calculator, container, false)
    }
    private fun onClickText(text: String) {
        text_visor.text = text
    }

    fun onClickFabButton(view: View) {

    }
    @OnClick(R.id.button_0, R.id.button_1,R.id.button_00, R.id.button_2, R.id.button_2_again, R.id.button_3,
    R.id.button_4, R.id.button_5, R.id.button_6, R.id.button_7, R.id.button_8, R.id.button_9)
    fun onClickNumber(view: View) {
        val number = view.tag.toString()
        Log.i(TAG, text_visor.text.toString())
        if(text_visor.text.toString() == "0") {
            text_visor.text = number
        } else {
            text_visor.append(number)
        }
    }
    /*
    fun onClickSymbol(view: View) {
        val symbol = view.tag.toString()
        text_visor.append(symbol)
    }
    fun onClickDelete(view: View) {
        val length = text_visor.text.length
        if(length > 1) {
            val newText = text_visor.text.subSequence(0, length-1)
            text_visor.text = newText
        } else {
            text_visor.text = "0"
        }
    }
    fun onClickEquals(view: View) {
        Log.i(TAG, "Click no botão =")
        val expression = ExpressionBuilder(text_visor.text.toString()).build()
        val result = expression.evaluate()
        val operation = Operation(text_visor.text.toString(), result)
        lastEquation = text_visor.text.toString()
        text_visor.text = operation.result.toString()
        lastEquation += "= ${text_visor.text}"
        Log.i(TAG, "O resultado da expressão é ${text_visor.text}")
        val orientation =text_visor.tag.toString()
        if(orientation == "landscape") {
            operations.add(operation)
            //list_historic.layoutManager = LinearLayoutManager(activity as Context)
            //list_historic.adapter = HistoryAdapter(activity as Context, R.layout.item_expression, operations)
        } else {
            operations_portrait.add(operation)
        }
    }
    fun onClickClearAll(view: View) {
        text_visor.text = "0"
    }

     */
}