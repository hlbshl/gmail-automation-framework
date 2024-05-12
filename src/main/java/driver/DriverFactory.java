package driver;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    private static final Map<String, DriverSetup> DRIVERS = new HashMap<>();

    static {
        DRIVERS.put("chrome", new ChromeDriverSetup());
        DRIVERS.put("firefox", new FirefoxDriverSetup());
    }

    public static WebDriver createDriver(String browser) {
        DriverSetup setup = DRIVERS.get(browser);
        if (setup == null) {
            throw new IllegalArgumentException("Invalid browser: " + browser);
        }
        return setup.getWebDriver();
    }
}