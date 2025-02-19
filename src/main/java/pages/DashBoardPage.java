package pages;

import org.openqa.selenium.By;

public class DashBoardPage extends BasePage
{
    // Locators
    private final By dashboardHeader = By.cssSelector(".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module");
    private final By userDropdown = By.cssSelector(".oxd-userdropdown-name");

    public boolean isDashboardDisplayed() {
        return isElementDisplayed(dashboardHeader);
    }

    public String getUserProfileName() {
        return getText(userDropdown);
    }
}
