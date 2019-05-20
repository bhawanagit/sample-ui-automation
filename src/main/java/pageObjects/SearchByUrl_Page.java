package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class SearchByUrl_Page extends BasePage {

    public @FindBy(css = "#gbw > div > div > div.gb_Dd.gb_f.gb_2f.gb_Sf > div:nth-child(2) > a") WebElement images_text;
    public @FindBy(css = ".S3Wjs") WebElement camera_icon;
    public @FindBy(css = "#qbui") WebElement edit_text_Search;
    public @FindBy(css = "#qbbtc > input") WebElement button_Search;
    public String visuallySimilarImages =".iu-card-header";

    public  SearchByUrl_Page() throws IOException
    {
        super();
    }
    public SearchByUrl_Page ClickOnImages() throws Exception{
        waitAndClickElement(images_text);
        return new SearchByUrl_Page();
    }
    public SearchByUrl_Page ClickOnCameraIcon() throws Exception{
        waitAndClickElement(camera_icon);
        return new SearchByUrl_Page();
    }
    public SearchByImage_Page addUrl(String SearchUrl) throws Exception {
        sendKeysToWebElement(edit_text_Search, SearchUrl);
        return new SearchByImage_Page();
    }

    public SearchByUrl_Page ClickOnSearchByImage() throws Exception {
        waitAndClickElement(button_Search);
        return new SearchByUrl_Page();
    }
    public SearchByUrl_Page ClickOnVisuallySimilarImages() throws Exception {
        waitAndClickElementsUsingByLocator(By.cssSelector(visuallySimilarImages));
        return new SearchByUrl_Page();
    }

    public String getText() throws Exception {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(visuallySimilarImages)));
        return driver.findElement(By.cssSelector(visuallySimilarImages)).getText();

    }
}
