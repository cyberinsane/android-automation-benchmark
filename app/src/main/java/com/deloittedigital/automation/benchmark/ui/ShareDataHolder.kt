package com.deloittedigital.automation.benchmark.ui

import android.content.SharedPreferences
import com.deloittedigital.automation.benchmark.AppClass

object ShareDataHolder {

    private var sharedPref: SharedPreferences? = null
    private var MY_SHARED_PREFERENCE = "MySharedPref"

    init {
        sharedPref = AppClass.getAppContext()?.getSharedPreferences(MY_SHARED_PREFERENCE, 0)

    }

    private fun addData(newData: String): Boolean {
        var tempString = sharedPref?.getString("abc", null)
        tempString = if (tempString.isNullOrEmpty()) {
            newData

        } else {
            StringBuilder(tempString).append(":").append(newData).toString()

        }
        val editor = this.sharedPref?.edit()
        editor?.putString("abc", tempString)
        editor?.apply()

        return true
    }

    private fun getData(): String? {
        return sharedPref?.getString("abc", null)
    }

    fun putUserData(
        firstName: String?,
        lastName: String?,
        password: String?,
        emailId: String?,
        phoneNumber: String?
    ): Boolean {

        val temp = StringBuilder().apply {
            append(firstName)
            append(",")
            append(lastName)
            append(",")
            append(password)
            append(",")
            append(emailId)
            append(",")
            append(phoneNumber)

        }

        return addData(temp.toString())
    }

    fun validateUser(emailId: String): Boolean {
        val tempArray = getData()?.split(":")
        tempArray?.forEach {
            if (it.contains(emailId)) {
                return true
            }
        }
        return false

    }

    fun validatePassword(password: String): Boolean {
        val tempArray = getData()?.split(":")

        tempArray?.forEach {
            if (it.contains(password)) {
                return true
            }
        }
        return false

    }

    fun fetchUserData(emailId: String): String? {
        val tempArray = getData()?.split(":")

        tempArray?.forEach {
            if (it.contains(emailId)) {
                return it
            }
        }
        return null
    }

    fun keepUser(emailId: String) {
        val editor = this.sharedPref?.edit()
        editor?.putString("keepUser", emailId)
        editor?.apply()

    }

    fun getLoggedInUser(): String {
        return sharedPref!!.getString("keepUser", "").toString()

    }

    fun removeUser() {
        val editor = this.sharedPref?.edit()
        editor?.putString("keepUser", "")
        editor?.apply()
    }

}