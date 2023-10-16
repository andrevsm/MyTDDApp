package br.com.avsm.mytddapp

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.avsm.mytddapp.view.UserActivity
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {
    @Test
    fun canRecreate(){
        val scenario = ActivityScenario.launch(UserActivity::class.java)
        scenario.recreate()
    }
    @Test
    fun viewsExists(){
        ActivityScenario.launch(UserActivity::class.java)
        Espresso.onView(ViewMatchers.withId(R.id.editTextLogin))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.editTextPassword))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.buttonCreateAccount))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}