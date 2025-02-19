package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PersonalDetailsPage;
import utils.Constants;
import utils.DriverFactory;

public class PersonalDetailsTests
{
    private LoginPage loginPage;
    private PersonalDetailsPage personalDetailsPage;

    @BeforeMethod
    public void setup() {
        DriverFactory.initDriver();
        DriverFactory.getDriver().get(Constants.BASE_URL);
        loginPage = new LoginPage();
        personalDetailsPage = new PersonalDetailsPage();
    }

    @Test
    public void testUpdateFirstName() {
        // Login first
        loginPage.login("Admin", "admin123");

        // New first name to set
        String newFirstName = "John";  // You can modify this or make it parameterized

        //Go to myinfo page
        personalDetailsPage.clickMyInfo();
        // Update first name
        personalDetailsPage.updateFirstName(newFirstName);
        personalDetailsPage.clickSaveButton();

        // Verify success message is displayed
//        Assert.assertTrue(personalDetailsPage.isSuccessToastDisplayed(),
//                "Success message should be displayed after saving");

        // Verify the first name was actually updated
        Assert.assertEquals(personalDetailsPage.getFirstName(), newFirstName,
                "First name should be updated to " + newFirstName);
        System.out.println(personalDetailsPage.getFirstName());
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
