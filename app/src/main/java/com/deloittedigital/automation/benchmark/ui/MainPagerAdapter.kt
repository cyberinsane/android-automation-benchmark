package com.deloittedigital.automation.benchmark.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.cyberinsane.twowayviewpager.AccountFragment
import com.cyberinsane.twowayviewpager.BagFragment
import com.cyberinsane.twowayviewpager.HomeFragment


class MainPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) {
            AccountFragment.newInstance()
        } else if (position == 1) {
            HomeFragment.newInstance()
        } else {
            BagFragment.newInstance()
        }
    }

    override fun getItemCount(): Int {
        return 3
    }
}