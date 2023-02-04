package com.example.fragmentinteraction

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DetailActivity : AppCompatActivity() {

    private var mSelectedItem: String = "Не выбрано"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish()
            return
        }
        setContentView(R.layout.activity_detail)
        val extras = intent.extras
        if (extras != null) {
            mSelectedItem = extras.getString("SELECTED_ITEM").toString()
        }
    }

    override fun onResume() {
        super.onResume()
        val fragment: DetailFragment = supportFragmentManager.findFragmentById(R.id.detailFragment)
            as DetailFragment
        fragment.setSelectedItem(mSelectedItem)
    }
}