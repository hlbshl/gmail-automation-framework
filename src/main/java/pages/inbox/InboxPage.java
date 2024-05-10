package pages.inbox;

import common.CommonAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;
import services.TestDataReader;

public class InboxPage extends BasePage {
    public static final String SUBJECT = "testdata.subject";
    public static final String BODY = "testdata.body";

    private final Logger logger = LogManager.getRootLogger();

    public InboxPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    private final By searchInput = By.xpath("//*[@id='gs_lc50']//input[1]");
    private final By composeButton = By.xpath("//div[contains(text(), 'Compose')]");
    private final By dialog = By.xpath("//div[@role='dialog']");
    private final By draft = By.xpath("//a[@aria-label='Drafts 1 unread']");
    private final By sent = By.cssSelector("a[aria-label='Sent']");
    private final By draftElement = By.xpath("//tr[@role='row']");
    private final By noDrafts = By.xpath("//td[contains(text(), \"You don't have any saved drafts.\")]");

    @Override
    public InboxPage openPage() {
        driver.get("https://mail.google.com/mail/?logout&hl=en");
        logger.info("Login page opened");
        return this;
    }

    public WebElement loginSuccessful() {
        WebElement inbox = driver.findElement(searchInput);
        waitForElement(inbox);
        logger.info("User is logged in");
        return inbox;
    }

    public WebElement composeEmail() {
        return driver.findElement(composeButton);
    }

    public InboxPage saveEmailToDraft() {
        waitForElement(driver.findElement(dialog));
        Actions actions = new Actions(driver);
        String recipient = CommonAction.randomStringCreator();
        actions.sendKeys(recipient).perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(TestDataReader.getTestData(SUBJECT)).perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(TestDataReader.getTestData(BODY)).perform();
        actions.sendKeys(Keys.ESCAPE).perform();
        logger.info("Email to " + recipient + " is saved to draft");
        return this;
    }

    public InboxPage navigateToDrafts() {
        driver.findElement(draft).click();
        waitForElement(elementExists());
        logger.info("User is navigated to drafts");
        return this;
    }

    public InboxPage navigateToSent() {
        driver.findElement(sent).click();
        waitForElement(elementExists());
        logger.info("User is navigated to sent messages");
        return this;
    }

    public WebElement elementExists() {
        return driver.findElement(draftElement);
    }

    public InboxPage openAndSendDraft() {
        driver.findElement(draftElement).click();
        waitForElement(driver.findElement(dialog));
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.ENTER).keyUp(Keys.CONTROL).perform();
        logger.info("Email is sent");
        return this;
    }

    public WebElement noDraftsMessage() {
        waitForElement(driver.findElement(noDrafts));
        return driver.findElement(noDrafts);
    }
}

