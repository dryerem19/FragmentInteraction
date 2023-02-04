package com.example.fragmentinteraction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return  inflater.inflate(R.layout.fragment_detail, container, false)
    }

    fun setSelectedItem(selectedItem: String) {
        val view = view?.findViewById<TextView>(R.id.detailsText)
        view?.text = selectedItem
    }

}
