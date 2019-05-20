package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.SearchByImage_Page;
import pageObjects.SearchByUrl_Page;
import utils.Constant;
import utils.DriverFactory;

public class SearchByImageSteps extends DriverFactory {

	@When("^User search for \"([^\"]*)\"$")
	public void user_search_for(String searchText) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		SearchByImagePage.SearchText(searchText);
	}


	@And("^User click on search button$")
	public void user_click_on_search_button() throws Throwable {
		SearchByImagePage.ClickOnSearch();
	}

	@And("^User should click on Images to explore more images$")
	public void user_should_click_on_Images_to_explore_more_images() throws Throwable {
		SearchByImagePage.ClickOnImages();
	}

	@And("^User should nevigate to third image$")
	public void user_should_nevigate_to_third_image() throws Throwable {
		//SearchByImage_Page.ClickOnImages();
	}
	@Then("^User navigates to the configured image result$")
	public void user_navigates_to_the_configured_image_result() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		SearchByImagePage.GoToConfiguredImage(Constant.VISIT_RESULT);
	}

	@When("^User clicks on search by image button$")
	public void user_clicks_on_search_by_image_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		SearchByImagePage.ClickOnSearchByImage();
	}

}
