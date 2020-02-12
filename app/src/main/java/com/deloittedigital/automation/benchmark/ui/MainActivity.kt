package com.deloittedigital.automation.benchmark.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.deloittedigital.automation.benchmark.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewPager.adapter = MainPagerAdapter(this)
    }

}