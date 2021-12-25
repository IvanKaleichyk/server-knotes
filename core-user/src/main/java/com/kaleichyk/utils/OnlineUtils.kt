package com.kaleichyk.utils

import java.util.*

// time between user actions, when he is considered online
private const val CONSIDERED_ONLINE_TIME = 60000 // 1 min

fun getOnlineTime(time: Long) = when {
    Date().time - time < CONSIDERED_ONLINE_TIME -> 0
    else -> time
}
