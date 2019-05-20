package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SearchByImage_Page extends BasePage {
  
    public @FindBy(css = ".gLFyf.gsfi") WebElement edit_text_Search;
    public @FindBy(css = ".gNO89b") WebElement button_Google_Search;
    public @FindBy(css = ".q.qs") WebElement text_Images;
    public String resultDisplayDiv = "#rg_s div:nth-child(toBereplaced) a";
    public String imageButton = ".S3Wjs";
    public  SearchByImage_Page() throws IOException
    {
        super();
    }
    public SearchByImage_Page SearchText(String SearchText) throws Exception{
        sendKeysToWebElement(edit_text_Search, SearchText);
        return new SearchByImage_Page();
    }
    public SearchByImage_Page ClickOnSearch() throws Exception{
        waitAndClickElement(button_Google_Search);
        return new SearchByImage_Page();
    }
    public  SearchByImage_Page ClickOnImages() throws Exception{
        waitAndClickElement(text_Images);
        return new SearchByImage_Page();
    }

    public SearchByImage_Page GoToConfiguredImage(String visitResult) throws Exception{
        resultDisplayDiv= resultDisplayDiv.replace("toBereplaced",visitResult);
        WebElement element = driver.findElement(By.cssSelector(resultDisplayDiv));
        waitAndClickElement(element);
        return new SearchByImage_Page();
    }

    public SearchByImage_Page ClickOnSearchByImage() throws Exception{
        waitAndClickElement(driver.findElement(By.cssSelector(imageButton)));
        return new SearchByImage_Page();
    }

}
