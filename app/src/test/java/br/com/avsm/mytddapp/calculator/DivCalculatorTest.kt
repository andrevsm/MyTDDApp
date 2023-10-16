package br.com.avsm.mytddapp.calculator

import br.com.avsm.mytddapp.model.CalculatorService
import br.com.avsm.mytddapp.controller.DependencyInjector
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class DivCalculatorTest {
    private lateinit var calculator: CalculatorService

    @Test
    fun testDivCalculatorPositiveNumbers() {
        val result = calculator.div("2", "2")
        assertEquals("1", result)
    }

    @Test
    fun testDivCalculatorNegativeNumbers() {
        val result = calculator.div("-2", "-2")
        assertEquals("1", result)
    }

    @Test
    fun testDivCalculatorPositiveNegativeNumber() {
        val result = calculator.div("3", "-2")
        assertEquals("-1", result)
    }

    @Before
    fun setUp() {
        val injector = DependencyInjector()
        calculator = injector.provideCalculatorService()
    }
}