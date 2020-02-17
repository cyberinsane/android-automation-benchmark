package com.deloittedigital.automation.benchmark.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.deloittedigital.automation.benchmark.R
import com.deloittedigital.automation.benchmark.ui.signup.SignUpActivity
import kotlinx.android.synthetic.main.activity_add_card.*

class AddCardActivity : AppCompatActivity(R.layout.activity_add_card) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        submitCard.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

    }
}
