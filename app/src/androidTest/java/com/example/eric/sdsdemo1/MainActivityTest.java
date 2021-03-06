package com.example.eric.sdsdemo1;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.eric.sdsdemo1.entities.Product;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void productListDisplayed() {
        onView(withId(R.id.ListProducts)).check(matches(isDisplayed()));
    }

    @Test
    public void productListNotEmpty() {
        onData(instanceOf(Product.class))
                .inAdapterView(allOf(withId(R.id.ListProducts), isDisplayed()))
                .atPosition(9)
                .check(matches(isDisplayed()));
    }

    @Test
    public void productCategoryWorks() {
        onView(allOf(withId(R.id.drawer_layout)))
                .perform(click())
                .check(matches(isDisplayed()));
    }

    @Test
    public void clickToViewProduct() {
        onData(instanceOf(Product.class))
                .inAdapterView(allOf(withId(R.id.ListProducts), isDisplayed()))
                .atPosition(9)
                .perform(click())
                .check(matches(isDisplayed()));
    }
}
