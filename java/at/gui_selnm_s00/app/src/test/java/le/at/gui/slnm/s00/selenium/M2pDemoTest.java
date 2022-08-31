package le.at.gui.slnm.s00.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

/**
 * A container for M2P site demo test. Selenium based.
 */
public class M2pDemoTest {

    WebDriver browser;

    @BeforeClass
    static void setupClass() {
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeMethod
    void setupTest() {
        browser = new FirefoxDriver();
        browser.manage().window().maximize();
    }

    @AfterMethod
    void teardown() {
        browser.quit();
    }

    @Test
    void checkContacts_wait() {
        // Arrange
        var wait5sec = new WebDriverWait(browser, Duration.ofSeconds(5));
        var contactsTabLocator = By.xpath("//a[contains(@href, '/contacts/')]");
        var nameElementLocator = By.xpath("//input[@name='Name']");

        // Open the home page of the site.
        browser.get("https://mentorpiece.education");

        // Switch to Contacts tab.
        var contactsTab = wait5sec
                .until(elementToBeClickable(contactsTabLocator));
        contactsTab.click();

        // Verify
        String title = browser.getTitle();
        assertThat(title).contains("Contacts");
        var nameField = wait5sec.until(elementToBeClickable(nameElementLocator));
        assertThat(nameField).isNotNull();
        assertThat(nameField.getText()).isEmpty();
    }

}
