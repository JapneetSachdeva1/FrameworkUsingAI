package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class PersonalDetailsPage extends BasePage
{
    // Locators
    private final By firstNameInput = By.cssSelector("input[name='firstName']");
    private final By saveButton = By.cssSelector("button[type='submit']");
    private final By successToast = By.cssSelector(".oxd-toast--success");
    private final By spinnerLoader = By.cssSelector(".oxd-loading-spinner");

    public void updateFirstName(String firstName) {
        // Wait for the page to load and fields to be interactive
        waitForElementToBeVisible(firstNameInput);
        // Clear existing text and enter new first name
        driver.findElement(firstNameInput).sendKeys(Keys.COMMAND+"A");
        driver.findElement(firstNameInput).sendKeys(Keys.DELETE);
        sendKeys(firstNameInput, firstName);
    }

    public void clickMyInfo()
    {
        driver.findElement(By.xpath("//a[@href='/web/index.php/pim/viewMyDetails']")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickSaveButton() {
        click(saveButton);
        // Wait for spinner to disappear (if present)
        try {
            wait.until(d -> !d.findElement(spinnerLoader).isDisplayed());
        } catch (Exception e) {
            // Spinner might not appear if save is quick
        }
    }

    public boolean isSuccessToastDisplayed() {
        return isElementDisplayed(successToast);
    }

    public String getFirstName() {
        return driver.findElement(firstNameInput).getAttribute("value");
    }
}
