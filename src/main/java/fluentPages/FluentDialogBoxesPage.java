package fluentPages;

import components.FooterComponent;
import components.HeaderComponent;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FluentDialogBoxesPage extends FluentBasePage{
    @FindBy(id = "my-prompt")
    @CacheLookup
    WebElement launchPromptButton;

    @CacheLookup
    @FindBy(id = "prompt-text")
    private WebElement launchPromptText;

    private String name;
    HeaderComponent header;
    FooterComponent footer;

    public FluentDialogBoxesPage(WebDriver driver) {
        super(driver);
        header = new HeaderComponent(driver);
        footer = new FooterComponent(driver);
        PageFactory.initElements(driver, this);
        visit("https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");
    }

    @Step("Click launch prompt button")
    public FluentDialogBoxesPage click(){
        launchPromptButton.click();
        return this;
    }

    @Step("Check alert is open")
    public FluentDialogBoxesPage openAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        return this;
    }

    @Step("Check alert text")
    public FluentDialogBoxesPage getAlertText () {
        assertEquals("Please enter your name", wait.until(ExpectedConditions.alertIsPresent()).getText());
        return this;
    }

    @Step("Enter name")
    public FluentDialogBoxesPage name(String name) {
        driver.switchTo().alert().sendKeys(name);
        this.name = name;
        return this;
    }

    @Step("Click OK button")
    public FluentDialogBoxesPage OK() {
        driver.switchTo().alert().accept();
        return this;
    }

    @Step("Click Cancel button")
    public FluentDialogBoxesPage Cancel() {
        driver.switchTo().alert().dismiss();
        return this;
    }

    @Step("Check entered name")
    public FluentDialogBoxesPage enterNameSuccess() {
        assertEquals("You typed: " + name, launchPromptText.getText());
        return this;
    }

    @Step("Check null enter")
    public FluentDialogBoxesPage enterNull() {
        assertEquals("You typed: null", launchPromptText.getText());
        return this;
    }

    public HeaderComponent getHeader() {
        return header;
    }

    public FooterComponent getFooter() {
        return footer;
    }
}
