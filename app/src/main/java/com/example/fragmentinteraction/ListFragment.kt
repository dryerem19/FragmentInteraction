package com.example.fragmentinteraction

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment

class ListFragment : Fragment() {

    interface IFragmentDataListener {
        fun onSendData(data: String)
    }

    private lateinit var mFragmentSendDataListener: IFragmentDataListener
    private val mCountries = arrayOf("Бразилия", "Аргентина",
        "Колумбия", "Чили", "Уругвай")

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            mFragmentSendDataListener = context as IFragmentDataListener
        } catch (e: ClassCastException) {
            val classname = context.toString()
            throw ClassCastException("$classname " +
                    "должен реализовывать интерфейс IFragmentDataListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val countriesList = view.findViewById<ListView>(R.id.countriesList)
        val adapter = ArrayAdapter(requireActivity(),
            android.R.layout.simple_list_item_1, mCountries.toList())
        countriesList.adapter = adapter
        countriesList.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val selectedItem = parent?.getItemAtPosition(position) as String
                mFragmentSendDataListener.onSendData(selectedItem)
            }
        return view
    }

}