package com.example.fragmentinteraction

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), ListFragment.IFragmentDataListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onSendData(data: String) {
        val fragment: DetailFragment = supportFragmentManager.
            findFragmentById(R.id.detailFragment) as DetailFragment
        if (fragment != null && fragment.isVisible) {
            fragment.setSelectedItem(data)
        } else {
            val i = Intent(applicationContext, DetailActivity::class.java)
            i.putExtra("SELECTED_ITEM", data)
            startActivity(i)
        }
    }
}