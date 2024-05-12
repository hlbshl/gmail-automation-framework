package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverSetup implements DriverSetup {
    @Override
    public WebDriver getWebDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
