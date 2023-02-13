package StepDefinitions;

import Utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class homePageStepDefinition {
    TestContextSetup tcs;

    public homePageStepDefinition(TestContextSetup tcs){
        this.tcs=tcs;
    }
    @Given("Open The Url")
    public void open_the_url() throws InterruptedException {
        tcs.pom.getHomePage().searchForVegetables("cucumber");
        tcs.pom.getHomePage().addMultipleProduct();

    }
    @When("Search For vegetable cucumber")
    public void search_for_vegetable_cucumber() {

    }
    @When("Click on Search Button")
    public void click_on_search_button() {

    }
    @Then("user is redirected to the new page")
    public void user_is_redirected_to_the_new_page() {

    }

}
