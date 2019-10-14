package com.github.luecy1.colabunofficial

import com.github.luecy1.colabunofficial.ui.date.toMMDD
import com.soywiz.klock.DateFormat
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun KlockUtilTest() {
        val dateString = "2019-11-01T19:00:00+09:00"
        val expected = "11/01"
        assertEquals(expected, dateString.toMMDD())
    }
}
