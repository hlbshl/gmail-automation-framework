package tests.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.inbox.InboxPage;
import pages.login.LoginPage;
import tests.base.BaseTest;

public class EmailCycleTest extends BaseTest {
    @Test
    public void loginIsSuccessful() {
        String searchFieldExpected = new LoginPage(driver)
                .openPage()
                .login().loginSuccessful().getAttribute("aria-label");

        Assert.assertEquals(searchFieldExpected, "Search mail", "Text is not found");
    }

    @Test
    public void saveEmailToDraft() {
        InboxPage inboxPage = new InboxPage(driver);
        inboxPage.composeEmail().click();
        inboxPage.saveEmailToDraft();
        inboxPage.navigateToDrafts();
        Assert.assertTrue(inboxPage.elementExists().isDisplayed());
    }

    @Test
    public void sendDraft() {
        InboxPage inboxPage = new InboxPage(driver);
        inboxPage.openAndSendDraft();
        Assert.assertTrue(inboxPage.noDraftsMessage().isDisplayed());
        inboxPage.navigateToSent();
        Assert.assertTrue(inboxPage.elementExists().isDisplayed());
        inboxPage.openPage();
    }
}
