package common;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static common.Config.IMPLICIT_WAIT;

public class CommonAction {
    private static WebDriver driver;

    private CommonAction() {
    }

    public static WebDriver getDriver() {
        if (null == driver) {
            driver = DriverFactory.createDriver(System.getProperty("browser"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}