package com.example.gfive.util

class TimeManager {
    companion object {
        fun getTimeWithAddDays(day: Int): Long {
            return System.currentTimeMillis() + (86400000 * day)
        }
    }
}