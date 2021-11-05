package com.example.futs.util

import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

const val DATE_FORMAT_DD = "dd"
const val DATE_FORMAT_MONTH = "MMMM yyyy"

fun Calendar.getNearestSunday(): Calendar {
    var thisDayOfWeek: Int = this.get(Calendar.DAY_OF_WEEK)

    if (thisDayOfWeek - 1 < 0) {
        thisDayOfWeek = 7 + (thisDayOfWeek - 1)
        this.add(Calendar.DATE, -1 * thisDayOfWeek)
    } else {
        this.add(Calendar.DATE, -1 * (thisDayOfWeek - 1))
    }

    this[Calendar.HOUR_OF_DAY] = 0
    this[Calendar.MINUTE] = 0
    this[Calendar.SECOND] = 0
    this[Calendar.MILLISECOND] = 0

    return this
}

fun Date.plusDays(days: Int): Date {
    val c = Calendar.getInstance()
    c.time = this
    c.add(Calendar.DATE, days)
    return c.time
}

fun Date.getDateOfMonth() : String {
    return SimpleDateFormat(DATE_FORMAT_DD, Locale.getDefault()).format(this)
}

fun Long.toDate(): Date {
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = this
    return calendar.time
}

fun Date.format(
    outputFormat: String,
    timeZone: TimeZone = TimeZone.getDefault()
) : String? {
    val output = SimpleDateFormat(outputFormat, Locale.getDefault() )
    output.timeZone = timeZone
    return try {
        output.format(time)
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}