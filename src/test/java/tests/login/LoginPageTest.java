package tests.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.login.LoginPage;
import tests.base.BaseTest;

public class LoginPageTest extends BaseTest {
    @Test
    public void loginIsSuccessful() {
        String searchFieldExpected = new LoginPage(driver)
                .openPage()
                .login().loginSuccessful().getAttribute("aria-label");

        Assert.assertEquals(searchFieldExpected, "Search mail", "Text is not found");
    }
}
