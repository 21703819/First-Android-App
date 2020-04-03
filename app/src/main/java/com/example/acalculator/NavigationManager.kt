package com.example.acalculator

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

abstract class NavigationManager {

    companion object {
        private fun placeFragment(fm: FragmentManager, fragment: Fragment) {
            val transition = fm.beginTransaction()
            transition.replace(R.id.frame, fragment)
            transition.addToBackStack(null)
            transition.commit()
        }
        fun goToCalculatorFragment(fm: FragmentManager) {
            placeFragment(fm, CalculatorFragment())
        }
        fun goToHistoryFragment(fm: FragmentManager, param1: ArrayList<Operation>) {
            placeFragment(fm, HistoryFragment.newInstance(param1))
        }

    }
}