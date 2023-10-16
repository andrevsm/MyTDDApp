package br.com.avsm.mytddapp

import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.avsm.mytddapp.view.MainActivity
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Test
    fun canRecreate() {
        val scenario = launch(MainActivity::class.java)
        scenario.recreate()
    }

    @Test
    fun viewsExists() {
        launch(MainActivity::class.java)
        onView(withId(R.id.loginButton)).check(matches(isDisplayed()))
        onView(withId(R.id.calculatorButton)).check(matches(isDisplayed()))
    }

}