package com.pamungkasandono.android3_myviewmodel

import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import java.lang.NullPointerException

class MainViewModelTest {
    private lateinit var mainViewModel: MainViewModel

    @get:Rule
    var thrown = ExpectedException.none()

    @Before
    fun init() {
        mainViewModel = MainViewModel()
    }

    @Test
    fun calc() {
        val width = "1"
        val length = "2"
        val height = "3"
        mainViewModel.calc(width, height, length)
        assertEquals(6, mainViewModel.result)
    }

    @Test
    @Throws(NumberFormatException::class)
    fun doubleInputTest() {
        val width = "1"
        val length = "2.4"
        val height = "3"
        thrown.expect(NumberFormatException::class.java)
        thrown.expectMessage("For input string: \"2.4\"")
        mainViewModel.calc(width, height, length)
    }@Test
    @Throws(NumberFormatException::class)
    fun charInputTest() {
        val width = "1"
        val length = "A"
        val height = "3"
        thrown.expect(NumberFormatException::class.java)
        thrown.expectMessage("For input string: \"A\"")
        mainViewModel.calc(width, height, length)
    }
    @Test
    @Throws(NumberFormatException::class)
    fun emptyInputTest() {
        val width = "1"
        val length = ""
        val height = "3"
        thrown.expect(NumberFormatException::class.java)
        thrown.expectMessage("For input string: \"\"")
        mainViewModel.calc(width, height, length)
    }


}