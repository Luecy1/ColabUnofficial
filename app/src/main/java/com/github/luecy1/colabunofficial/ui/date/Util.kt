package com.github.luecy1.colabunofficial.ui.date

import com.soywiz.klock.DateException
import com.soywiz.klock.DateFormat
import com.soywiz.klock.DateTimeTz
import com.soywiz.klock.parse


fun CharSequence.toMMDD(): String = try {
    val dateFormat = DateFormat.FORMAT1
    val date: DateTimeTz = dateFormat.parse(this.toString())
    date.toString("MM/dd")

} catch (e: DateException) {
    ""
}