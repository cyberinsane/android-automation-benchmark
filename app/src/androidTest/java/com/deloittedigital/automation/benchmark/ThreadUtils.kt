package com.deloittedigital.automation.benchmark

object ThreadUtils {
    private const val VERY_LONG = 15000
    private const val LONG = 10000
    private const val MEDIUM = 5000
    private const val SHORT = 2000
    private const val VERY_SHORT = 500

    fun performWaitLong() {
        performWait(LONG)
    }

    fun performWaitVeryLong() {
        performWait(VERY_LONG)
    }

    fun performWaitMedium() {
        performWait(MEDIUM)
    }

    fun performWaitShort() {
        performWait(SHORT)
    }

    fun performWaitVeryShort() {
        performWait(VERY_SHORT)
    }

    private fun performWait(wait: Int) {
        try {
            Thread.sleep(wait.toLong())
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}
