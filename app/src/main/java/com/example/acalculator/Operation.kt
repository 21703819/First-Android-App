package com.example.acalculator

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import net.objecthunter.exp4j.ExpressionBuilder

@Parcelize
class Operation(val expression: String, var result: Double) :Parcelable{

}