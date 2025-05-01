package fluentPages;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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

    @CacheLookup
    @FindBy(id = "my-modal")
    private WebElement launchModalButton;

    public FluentDialogBoxesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        visit("https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");
    }

    @Step("Click launch prompt button")
    public FluentDialogBoxesPage click() throws InterruptedException {
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
        Alert launchPrompt = wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().sendKeys(name);
        String enteredName = name;
        return this;
    }

    @Step("Click OK button")
    public FluentDialogBoxesPage OK() {
        driver.switchTo().alert().accept();
        return this;
    }

    @Step("Check entered name")
    public FluentDialogBoxesPage enterNameSuccess(String enteredName) throws InterruptedException {

//
//        Alert launchPrompt = wait.until(ExpectedConditions.alertIsPresent());
//        assertEquals("Please enter your name", launchPrompt.getText());
//        launchPrompt.sendKeys("Mariya");
//        launchPrompt.accept();

        //String inputName = name;
        assertEquals("You typed: " + enteredName, launchPromptText.getText());
        Thread.sleep(3000);
        return this;
    }
}
