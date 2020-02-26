package com.deloittedigital.automation.benchmark.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.deloittedigital.automation.benchmark.R
import kotlinx.android.synthetic.main.activity_add_card.*


class AddCardActivity : AppCompatActivity(R.layout.activity_add_card) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        submitCard.setOnClickListener {
            ShareDataHolder.putUserCardData(
                ccNumber.text.toString(),
                ccExpDate.text.toString(),
                ccCardholderName.text.toString(),
                ccBillingZip.text.toString(),
                ShareDataHolder.getLoggedInUser()
            )
            startActivity(MainActivity.createIntentForBag(this))
        }

    }
}
