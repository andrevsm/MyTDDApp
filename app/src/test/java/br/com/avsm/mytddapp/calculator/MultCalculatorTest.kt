package br.com.avsm.mytddapp.calculator

import br.com.avsm.mytddapp.model.CalculatorService
import br.com.avsm.mytddapp.controller.DependencyInjector
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MultCalculatorTest {
    private lateinit var calculator: CalculatorService

    @Test
    fun testMultCalculatorPositiveNumbers() {
        val result = calculator.mult("2", "2")
        assertEquals("4", result)
    }

    @Test
    fun testMultCalculatorNegativeNumbers() {
        val result = calculator.mult("-2", "-2")
        assertEquals("4", result)
    }

    @Test
    fun testMultCalculatorPositiveNegativeNumber() {
        val result = calculator.mult("3", "-2")
        assertEquals("-6", result)
    }

    @Before
    fun setUp() {
        val injector = DependencyInjector()
        calculator = injector.provideCalculatorService()
    }
}