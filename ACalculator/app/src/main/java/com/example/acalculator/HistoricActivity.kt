package com.example.acalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.core.view.forEachIndexed
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_historic.*

class HistoricActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historic)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val list = intent.getParcelableArrayListExtra<Operation>(EXTRA_LIST)
        list?.let {
            list_historic_verical.layoutManager = LinearLayoutManager(this)
            list_historic_verical.adapter = HistoryAdapter(this, R.layout.item_expression, list)
            list_historic_verical.setOnClickListener {
                //Toast.makeText(this,, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val newIntent = Intent(applicationContext, MainActivity::class.java)
        startActivityForResult(newIntent, 0)
        return true
    }
}
