package com.example.acalculator

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.ButterKnife
import kotlinx.android.synthetic.main.fragment_history.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [HistoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HistoryFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: ArrayList<Operation>? = null

    private val TAG = HistoryFragment::class.java.simpleName

    private lateinit var viewModel: CalculatorViewModel

    private var layout_view: RecyclerView? = null

    private var list: List<Operation> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_history, container, false)
        viewModel = ViewModelProviders.of(this).get(CalculatorViewModel::class.java)
        ButterKnife.bind(this,view)
        activity?.title = "Historico"

        list = viewModel.getOperations()
        Log.i(TAG, "dçajflkjsdklfjlkasdjfklsadklf   ${list.size}")

        layout_view = view?.findViewById(R.id.list_historic)
        layout_view?.layoutManager = LinearLayoutManager(this.context)
        layout_view?.adapter = HistoryAdapter(context!!, R.layout.item_expression, list)


        return view
    }
}
