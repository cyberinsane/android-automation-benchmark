package com.deloittedigital.automation.benchmark.ui.account

import androidx.lifecycle.ViewModel
import com.deloittedigital.automation.benchmark.ui.ShareDataHolder

class AccountFragViewModel : ViewModel() {

    fun loadUsers(userName: String): String? {
        return ShareDataHolder.fetchUserData(userName)

    }

    fun getUserName(): CharSequence? {
        val temp = getUserData()

        return temp?.split(",")?.get(0)

    }

    private fun getUserData(): String? {
        if (ShareDataHolder.getLoggedInUser().isNotEmpty()) {
            return ShareDataHolder.fetchUserData(ShareDataHolder.getLoggedInUser())
        }
        return null

    }

    fun getEmailID(): CharSequence? {
        val temp = getUserData()
        return temp?.split(",")?.get(3)

    }

    fun getPhoneNumber(): CharSequence? {
        val temp = getUserData()
        return temp?.split(",")?.get(4)
    }

}