package ui.fluent;

import fluentPages.FluentLoginPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Fluent")
public class FluentLoginPageTests extends BaseTest{
    FluentLoginPage loginPage;

    @BeforeEach
    void initPages() {
        loginPage = new FluentLoginPage(driver);
    }

    @Test
    void testLoginSuccess() {
        loginPage
                .login("user", "user")
                .checkSuccessBoxPresent()
                .checkInvalidCredentialsBoxIsNotPresent();
    }

    @Test
    void testLoginFailure() {
        loginPage
                .login("test", "test")
                .checkInvalidCredentialsBoxPresent()
                .checkSuccessBoxIsNotPresent();
    }

    @Test
    void HeaderTest() {
        String headerText = loginPage
                .getHeader().getSubTitleText();

        assertEquals("Practice site", headerText);
    }

    @Test
    void FooterTest() {
        String footerText = loginPage
                .getFooter().getFooterText();

        assertTrue(footerText.contains("2021-2025 Boni"), footerText);
    }
}
