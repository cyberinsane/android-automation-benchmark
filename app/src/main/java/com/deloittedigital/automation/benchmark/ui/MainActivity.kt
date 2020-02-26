package com.deloittedigital.automation.benchmark.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.deloittedigital.automation.benchmark.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    companion object {
        const val EXTRA_GOTO_BAG = "go to bag"

        fun createIntentForBag(context: Context?): Intent? {
            val intent = Intent(context, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            intent.putExtra(EXTRA_GOTO_BAG, true)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewPager.adapter = MainPagerAdapter(this)
        if (intent.hasExtra(EXTRA_GOTO_BAG)) {
            intent.removeExtra(EXTRA_GOTO_BAG)
            viewPager.setCurrentItem(2, false)
        }

    }

}