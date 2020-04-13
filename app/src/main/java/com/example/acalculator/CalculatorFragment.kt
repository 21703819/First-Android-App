package com.example.acalculator

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import butterknife.ButterKnife
import butterknife.OnClick
import butterknife.Optional
import kotlinx.android.synthetic.main.fragment_calculator.*
import kotlinx.android.synthetic.main.fragment_calculator.view.*
import net.objecthunter.exp4j.ExpressionBuilder


class CalculatorFragment : Fragment(), OnDisplayChanged {

    private val TAG = CalculatorFragment::class.java.simpleName

    private lateinit var viewModel: CalculatorViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = "ACalculator"
        val view: View = inflater.inflate(R.layout.fragment_calculator, container, false)
        viewModel = ViewModelProviders.of(this).get(CalculatorViewModel::class.java)
        viewModel.display.let { view.text_visor.text = it }
        ButterKnife.bind(this, view)
        return view
    }

    @Optional
    @OnClick(R.id.button_last_equation)
    fun onLastEquation(view: View) {
        viewModel.onLastEquation()
    }
    @Optional
    @OnClick(
        R.id.button_adition,
        R.id.button_divide,
        R.id.button_multiplicate,
        R.id.button_sub,
        R.id.button_dot,
        R.id.button_0,
        R.id.button_1,
        R.id.button_2,
        R.id.button_3,
        R.id.button_4,
        R.id.button_5,
        R.id.button_6,
        R.id.button_7,
        R.id.button_8,
        R.id.button_9,
        R.id.button_2_again,
        R.id.button_00
    )
    fun onClickSymbol(view: View) {
        viewModel.onClickSymbol(view.tag.toString())
    }

    @OnClick(R.id.button_clear_last)
    fun onClickDelete(view: View) {
        viewModel.onClickDelete()
    }

    @OnClick(R.id.button_equals)
    fun onClickEquals(view: View) {
        viewModel.onClickEquals()
    }

    @OnClick(R.id.button_clear_all)
    fun onClickClearAll(view: View) {
        viewModel.onClickClearAll()
    }

    override fun onStart() {
        viewModel.registerListener(this)
        super.onStart()
    }

    override fun onDisplayChanged(value: String?) {
        value?.let { text_visor.text = it }
    }
    override fun onDestroy() {
        viewModel.unregisterListener()
        super.onDestroy()
    }
}