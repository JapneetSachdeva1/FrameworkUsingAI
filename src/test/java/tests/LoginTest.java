package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashBoardPage;
import pages.LoginPage;
import utils.Constants;
import utils.DriverFactory;

public class LoginTest
{
    private LoginPage loginPage;
    private DashBoardPage dashboardPage;

    @BeforeMethod
    public void setup() {
        DriverFactory.initDriver();
        DriverFactory.getDriver().get(Constants.BASE_URL);
        loginPage = new LoginPage();
        dashboardPage = new DashBoardPage();
    }

    @Test
    public void testSuccessfulLogin() {
        loginPage.login("Admin", "admin123");
        Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard should be displayed after successful login");
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        loginPage.login("Admin", "wrongpassword");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed for invalid credentials");
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
