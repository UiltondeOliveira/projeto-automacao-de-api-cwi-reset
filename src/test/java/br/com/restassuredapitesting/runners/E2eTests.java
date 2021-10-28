package br.com.restassuredapitesting.runners;

import br.com.restassuredapitesting.tests.booking.tests.PostBookingTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(br.com.restassuredapitesting.suites.E2eTests.class)
@Suite.SuiteClasses({
        PostBookingTest.class
})
public class E2eTests {
}
