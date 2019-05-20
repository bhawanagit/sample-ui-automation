package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageObjects.BasePage;
import utils.Constant;
import utils.DriverFactory;


import java.io.IOException;

public class BaseSteps extends DriverFactory  {
    
    @Given("^I navigate to Google$")
    public void i_navigate_to_Google() {
    	 getDriver().get(Constant.Base_Url);
    }

}
