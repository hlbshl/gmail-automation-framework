package pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;
import pages.inbox.InboxPage;

public class LoginPage extends BasePage {

    public static final String EMAIL = "selenium.testng.dz1";
    public static final String PASSWORD = "Automation4ever!";
    private final String PAGE_URL = "https://gmail.com";

    private final By email = By.id("identifierId");
    private final By password = By.xpath("//*[@id='password']//input");

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public LoginPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public InboxPage login() {
        driver.findElement(email).sendKeys(EMAIL, Keys.RETURN);
        waitForElement(driver.findElement(password));
        driver.findElement(password).sendKeys(PASSWORD, Keys.RETURN);
        return new InboxPage(driver);
    }

}
