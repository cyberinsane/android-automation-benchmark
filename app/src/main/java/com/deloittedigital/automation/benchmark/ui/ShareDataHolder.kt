package com.deloittedigital.automation.benchmark.ui

import android.content.SharedPreferences
import com.deloittedigital.automation.benchmark.AppClass
import java.util.*

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
            if (it == emailId) {
                return true
            }
        }
        return false

    }

    fun validatePassword(password: String): Boolean {
        val tempArray = getData()?.split(":")

        tempArray?.forEach {
            if (it == password) {
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

    fun putUserCardData(cardNumber: String?, expiryDate: String,
        cardHolderName: String?, zipCode: String?, emailId: String): Boolean {

        val temp = StringBuilder().apply {
            append(cardNumber)
            append(",")
            append(expiryDate)
            append(",")
            append(cardHolderName)
            append(",")
            append(zipCode)
        }

        var tempString = sharedPref?.getString(emailId, null)

        tempString = if (tempString.isNullOrEmpty()) {
            temp.toString()
        } else {
            StringBuilder(temp).append(":").append(tempString).toString()
        }
        val editor = this.sharedPref?.edit()
        editor?.putString(emailId, tempString)
        editor?.apply()

        return true

    }

    fun fetchUserCardData(emailId: String): List<String>? {
        return sharedPref?.getString(emailId, null)?.split(":")
    }

}