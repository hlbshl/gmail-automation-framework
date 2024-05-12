package pages;

import org.openqa.selenium.WebDriver;
import pages.login.LoginPage;
import utils.LoggerUtil;

public class PageDecorator extends LoginPage {
    private LoginPage page;

    private static final String PAGE_URL = "https://gmail.com";

    public PageDecorator(LoginPage page, WebDriver driver) {
        super(driver);
        this.page = page;
    }

    @Override
    public LoginPage openPage() {
        LoggerUtil.logInfo("Opening a Log In page");
        driver.navigate().to(PAGE_URL);
        LoggerUtil.logInfo("Successfully opened Log In page");
        return this;
    }
}