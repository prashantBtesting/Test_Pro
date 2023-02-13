package StepDefinitions;

import Utils.TestContextSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {
    TestContextSetup tcs;

    public Hooks(TestContextSetup tcs) {
        this.tcs = tcs;
    }

    @Before
    public void beforeScenario() {
        tcs.pom.getHomePage().productCountAvailableOnPage();

    }
    @After
    public void afterScenario() throws IOException {
        tcs.base.initializeDriver().quit();

        System.out.println("Prashant");
    }
}
