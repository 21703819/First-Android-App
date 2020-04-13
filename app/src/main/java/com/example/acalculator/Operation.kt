package com.example.acalculator

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import net.objecthunter.exp4j.ExpressionBuilder
import java.util.*

class Operation(val expression: String, var result: Double){
    val uuid: String = UUID.randomUUID().toString()
}