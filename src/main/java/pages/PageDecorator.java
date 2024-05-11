package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.login.LoginPage;

public class PageDecorator extends LoginPage {
    private LoginPage page;

    private static final String PAGE_URL = "https://gmail.com";

    private final Logger logger = LogManager.getRootLogger();

    public PageDecorator(LoginPage page, WebDriver driver) {
        super(driver);
        this.page = page;
    }

    @Override
    public LoginPage openPage() {
        logger.info("Opening a Log In page");
        driver.navigate().to(PAGE_URL);
        logger.info("Successfully opened Log In page");
        return this;
    }
}