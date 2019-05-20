package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import utils.Constant;
import utils.DriverFactory;

public class SearchByUrlSteps extends DriverFactory {

    @When("^User click on Images text$")
    public void user_click_on_Images_text() throws Throwable {
        SearchByUrlPage.ClickOnImages();
    }

    @And("^User click on camera icon$")
    public void user_click_on_camera_icon() throws Throwable {
        SearchByUrlPage.ClickOnCameraIcon();
    }

    @Then("^User add the url$")
    public void user_add_the_url() throws Throwable {
        SearchByUrlPage.addUrl(Constant.Image_url);
    }

    @And("^User click on search by image button$")
    public void user_click_on_search_by_image_button() throws Throwable {
        SearchByUrlPage.ClickOnSearchByImage();
    }
    @Then("^User should nevigate to third image result$")
    public void user_should_nevigate_to_third_image_result() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        SearchByUrlPage.ClickOnVisuallySimilarImages();
    }

    @And("^User verify the configured image result$")
    public void user_verify_the_configured_image_result() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        String text = SearchByUrlPage.getText();
        Assert.assertEquals(text,"Visually similar images");
    }





}
