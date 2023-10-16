package br.com.avsm.mytddapp

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.avsm.mytddapp.view.MainActivity
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CalculatorActivityTest {
    @Test
    fun testSum(){
        ActivityScenario.launch(MainActivity::class.java)
        Espresso.onView(ViewMatchers.withId(R.id.num1EditText)).perform(
            ViewActions.clearText(),
            ViewActions.typeText("3")
        )
        Espresso.onView(ViewMatchers.withId(R.id.num2EditText)).perform(
            ViewActions.clearText(),
            ViewActions.typeText("2")
        )

        Espresso.onView(ViewMatchers.withId(R.id.sumButton)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
            .check(ViewAssertions.matches(ViewMatchers.withText("5")))

        Espresso.onView(ViewMatchers.withId(R.id.subButton)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
            .check(ViewAssertions.matches(ViewMatchers.withText("1")))

        Espresso.onView(ViewMatchers.withId(R.id.multButton)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
            .check(ViewAssertions.matches(ViewMatchers.withText("6")))

        Espresso.onView(ViewMatchers.withId(R.id.divButton)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.resultTextView))
            .check(ViewAssertions.matches(ViewMatchers.withText("1.5")))

    }
}