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
        fun onSendData(country: String, desc: String)
    }

    private lateinit var mFragmentSendDataListener: IFragmentDataListener
    private val mCountries = arrayOf("Бразилия", "Аргентина",
        "Колумбия", "Чили", "Уругвай")

    private val mDesc = arrayOf("Суверенное государство в Южной Америке. Площадь - 8 515 767 км². " +
            "Будучи пятой среди стран мира по площади и седьмой по численности населения, " +
            "Бразилия является крупнейшей страной Южной Америки и всей Латинской Америки как по " +
            "территории, так и по численности населения. Единственная португалоязычная страна во " +
            "всей Америке, а также самая большая лузофонная страна на планете.",

        "Второе после Бразилии по территории и третье после Бразилии и Колумбии по населению " +
                "государство Южной Америки, состоящее из 24 административных единиц: 23 провинций и" +
                " федерального столичного округа Буэнос-Айрес. Крупнейшая по площади в мире из " +
                "испаноязычных стран.",


        "Государство на северо-западе Южной Америки, с территориями в Центральной Америке. Столица " +
                "- Богота. Граничит с Бразилией и Венесуэлой на востоке, на юге - с Эквадором и " +
                "Перу, на западе - с Панамой.",


        "Государство на юго-западе Южной Америки, занимающее длинную узкую полосу земли между Тихим " +
                "океаном и Андами. На западе омывается Тихим океаном, на востоке граничит с " +
                "Аргентиной, на севере - с Перу, на северо-востоке - с Боливией.",

        "Государство в юго-восточной части Южной Америки, на побережье Атлантического океана. На " +
                "севере граничит с Бразилией, на западе - с Аргентиной, на востоке и юге омывается " +
                "Атлантическим океаном. Сухопутные границы имеют протяжённость 1564 км, " +
                "береговая линия - 660 км. ")

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
        val adapter = ArrayAdapter(requireContext(),
            android.R.layout.simple_list_item_1, mCountries)
        countriesList.adapter = adapter
        countriesList.onItemClickListener =
            AdapterView.OnItemClickListener { parent, _, position, _ ->
                val selectedCountry: String = parent?.getItemAtPosition(position) as String
                val desc: String = mDesc[position]
                mFragmentSendDataListener.onSendData(selectedCountry, desc)
            }
        return view
    }

}