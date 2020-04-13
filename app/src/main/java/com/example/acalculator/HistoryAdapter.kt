package com.example.acalculator

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_expression.view.*


class HistoryAdapter(private val context: Context, private val layout: Int, private var items: List<Operation>) :
RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {
    private val TAG = HistoryAdapter::class.java.simpleName
    class HistoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val expression: TextView = view.text_expression
        val result: TextView = view.text_result

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(LayoutInflater.from(context).inflate(layout, parent, false))
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.expression.text = items[position].expression
        holder.result.text = items[position].result.toString()

        holder.itemView.setOnLongClickListener {
            // Do your stuff
            val items2 = items.toMutableList().apply {
                Log.i(TAG, "skçdjalsjflkajdlfjlkasçlfjsljfkasljhlsaljflsajflksaj      ${items.size}")
                removeAt(position)
                notifyDataSetChanged()
            }
            items = items2
            false
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}
