package br.com.avsm.mytddapp.calculator

import br.com.avsm.mytddapp.model.CalculatorService
import br.com.avsm.mytddapp.controller.DependencyInjector
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class SumCalculatorTest {
    private lateinit var calculator: CalculatorService

    @Test
    fun testSumCalculatorPositiveNumbers() {
        val result = calculator.sum("2", "2")
        assertEquals("4", result)
    }

    @Test
    fun testSumCalculatorNegativeNumbers() {
        val result = calculator.sum("-2", "-2")
        assertEquals("-4", result)
    }

    @Test
    fun testSumCalculatorPositiveNegativeNumber() {
        val result = calculator.sum("3", "-2")
        assertEquals("1", result)
    }

    @Before
    fun setUp() {
        val injector = DependencyInjector()
        calculator = injector.provideCalculatorService()
    }
}