package tests.base;

import common.CommonAction;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.base.BasePage;
import pages.inbox.InboxPage;
import pages.login.LoginPage;

import java.util.Set;

public class BaseTest {

    protected WebDriver driver;

    protected void switchWindow() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String window1 = driver.getWindowHandle();
        js.executeScript("window.open()");
        Set<String> currentWindows = driver.getWindowHandles();
        String window2 = null;
        for (String window : currentWindows) {
            if (!window.equals(window1)) {
                window2 = window;
                break;
            }
        }
        driver.switchTo().window(window2);
    }

    protected void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            js.executeScript("arguments[0].style.border='3px solid red'", element);
            Thread.sleep(5000);
            js.executeScript("arguments[0].style.border=''", element);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeClass
    public void setUp() {
        driver = CommonAction.createDriver();
    }

    @AfterClass
    public void quit() {
       CommonAction.closeDriver();
    }
}
