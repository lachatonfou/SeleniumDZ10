package fluentPages;

import components.FooterComponent;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import components.HeaderComponent;

import static org.assertj.core.api.Assertions.assertThat;

public class FluentLoginPage extends FluentBasePage {
    @FindBy(id = "username")
    @CacheLookup
    WebElement usernameInput;

    @FindBy(id = "password")
    @CacheLookup
    WebElement passwordInput;

    @FindBy(css = "button")
    @CacheLookup
    WebElement submitButton;

    @FindBy(id = "success")
    @CacheLookup
    WebElement successBox;

    @FindBy(id = "invalid")
    @CacheLookup
    WebElement invalidCredentialsBox;

    HeaderComponent header;
    FooterComponent footer;

    public FluentLoginPage(WebDriver driver) {
        super(driver);
        header = new HeaderComponent(driver);
        footer = new FooterComponent(driver);
        PageFactory.initElements(driver, this);
        visit("https://bonigarcia.dev/selenium-webdriver-java/login-form.html");
    }

    @Step("Login")
    public FluentLoginPage login(String username, String password) {
        type(usernameInput, username);
        type(passwordInput, password);
        click(submitButton);
        return this;
    }

    @Step("Check success box present")
    public FluentLoginPage checkSuccessBoxPresent() {
        assertThat(isDisplayed(successBox)).isTrue();
        return this;
    }

    @Step("Check success box is not present")
    public FluentLoginPage checkSuccessBoxIsNotPresent() {
        assertThat(isDisplayed(successBox)).isFalse();
        return this;
    }

    @Step("Check invalid credentials box is present")
    public FluentLoginPage checkInvalidCredentialsBoxPresent() {
        assertThat(isDisplayed(invalidCredentialsBox)).isTrue();
        return this;
    }

    @Step("Check invalid credentials box is not present")
    public FluentLoginPage checkInvalidCredentialsBoxIsNotPresent() {
        assertThat(isDisplayed(invalidCredentialsBox)).isFalse();
        return this;
    }

    public HeaderComponent getHeader() {
        return header;
    }

    public FooterComponent getFooter() {
        return footer;
    }
}
