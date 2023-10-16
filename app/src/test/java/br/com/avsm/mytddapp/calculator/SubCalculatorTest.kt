package br.com.avsm.mytddapp.calculator

import br.com.avsm.mytddapp.model.CalculatorService
import br.com.avsm.mytddapp.controller.DependencyInjector
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class SubCalculatorTest {
    private lateinit var calculator: CalculatorService

    @Test
    fun testSubCalculatorPositiveNumbers() {
        val result = calculator.sub("2", "2")
        assertEquals("0", result)
    }

    @Test
    fun testSubCalculatorNegativeNumbers() {
        val result = calculator.sub("-2", "-2")
        assertEquals("0", result)
    }

    @Test
    fun testSubCalculatorPositiveNegativeNumber() {
        val result = calculator.sub("3", "-2")
        assertEquals("5", result)
    }

    @Before
    fun setUp() {
        val injector = DependencyInjector()
        calculator = injector.provideCalculatorService()
    }
}