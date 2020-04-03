package com.example.acalculator

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
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

    private val TAG = CalculatorFragment::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_history, container, false)
        ButterKnife.bind(this,view)
        activity?.title = "Historico"
        list_historic?.layoutManager = LinearLayoutManager(activity as Context)
        arguments?.let {
            param1 = it.getParcelableArrayList(EXTRA_LIST)

        }
        list_historic?.adapter = HistoryAdapter(activity as Context, R.layout.item_expression,
            this.param1!!
        )
        (list_historic?.adapter as HistoryAdapter?)?.notifyDataSetChanged()
        for(i in (param1 )!!) {
            Log.i(TAG, "ENTREIIII")
            Log.i(TAG, "${i.result}")
            //os dados chegaram
        }
        return view
    }
    companion object {
        @JvmStatic
        fun newInstance(param1:ArrayList<Operation>) : HistoryFragment{
            val fragment = HistoryFragment()
            val args = Bundle()
            args.putParcelableArrayList(EXTRA_LIST, param1)
            fragment.arguments = args
            return fragment
        }
    }
}
