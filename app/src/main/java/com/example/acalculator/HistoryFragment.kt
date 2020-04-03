package com.example.acalculator

import android.content.Context
import android.os.Bundle
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
        arguments?.let {
            param1 = it.getParcelableArrayList(EXTRA_LIST)

        }
        list_historic_verical?.layoutManager = LinearLayoutManager(activity as Context)
        list_historic_verical?.adapter =
            param1?.let { HistoryAdapter(activity as Context, R.layout.item_expression, it) }

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
