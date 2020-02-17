package com.deloittedigital.automation.benchmark.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.deloittedigital.automation.benchmark.ui.account.AccountFragment
import com.deloittedigital.automation.benchmark.ui.bag.BagFragment
import com.deloittedigital.automation.benchmark.ui.home.HomeFragment

class MainPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                AccountFragment.newInstance()
            }
            1 -> {
                HomeFragment.newInstance()
            }
            else -> {
                BagFragment.newInstance()
            }
        }
    }

    override fun getItemCount(): Int {
        return 3
    }
}