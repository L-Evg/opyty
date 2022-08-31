package le.at.gui.slnm.s00.selenide;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * A container for M2P site demo test. Selenide based.
 */
public class M2pDemoTest {

    @BeforeClass
    static void setupClass() {
        Configuration.browser = "firefox";
    }

    @Test
    void checkContacts_wait() {
        // Arrange
        var contactsTabLocator = By.xpath("//a[contains(@href, '/contacts/')]");
        var nameElementLocator = By.xpath("//input[@name='Name']");

        // Open the home page of the site.
        open("https://mentorpiece.education");

        // Switch to Contacts tab.
        $(contactsTabLocator).should(exist)
                .shouldBe(visible)
                .shouldBe(enabled)
                .click();

        // Verify
        String title = title();
        assertThat(title).contains("Contacts");
        $(nameElementLocator)
                .should(exist)
                .shouldBe(visible)
                .shouldBe(enabled)
                .shouldHave(exactText(""));
    }

}
