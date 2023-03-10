package com.example.fragmentinteraction

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DetailActivity : AppCompatActivity() {

    private var mSelectedCountry: String? = "Не выбрано"
    private var mDesc: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish()
            return
        }
        setContentView(R.layout.activity_detail)
        val extras = intent.extras
        if (extras != null) {
            mSelectedCountry = extras.getString("SELECTED_ITEM")
            mDesc = extras.getString("SELECTED_DESC")
        }
    }

    override fun onResume() {
        super.onResume()
        (supportFragmentManager.findFragmentById(R.id.detailFragment)
                as DetailFragment?)?.setSelectedItem(mSelectedCountry, mDesc)
    }
}