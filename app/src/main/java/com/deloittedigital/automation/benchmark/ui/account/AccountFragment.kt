package com.deloittedigital.automation.benchmark.ui.account

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.deloittedigital.automation.benchmark.R
import com.deloittedigital.automation.benchmark.ui.login.LoginActivity
import com.deloittedigital.automation.benchmark.ui.MainActivity
import com.deloittedigital.automation.benchmark.ui.ShareDataHolder
import kotlinx.android.synthetic.main.fragment_account.*

class AccountFragment : Fragment(R.layout.fragment_account) {

    private var viewModel: AccountFragViewModel? = null

    companion object {
        fun newInstance() =
            AccountFragment()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel =
            ViewModelProvider(this).get<AccountFragViewModel>(
                AccountFragViewModel::class.java)

        initData()

        signOut.setOnClickListener {
            ShareDataHolder.removeUser();
            context?.let {
                startActivity(
                    LoginActivity.createIntent(
                        it
                    )
                );
                (it as MainActivity).finish()
            }

        }
    }

    private fun initData() {
        viewModel?.let {
            profile_name.text = it.getUserName()
            profile_email.text = it.getEmailID()
            profile_phone.text = it.getPhoneNumber()
        }

    }

}