package ui.fluent;

import fluentPages.FluentDialogBoxesPage;
import fluentPages.FluentLoginPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.BaseTest;

@Feature("Fluent")
public class FluentDialogBoxesTests extends BaseTest {
    FluentDialogBoxesPage dialogBoxesPage;

    @BeforeEach
    void initPages() {
        dialogBoxesPage = new FluentDialogBoxesPage(driver);
    }

    @Test
    void enterSuccess() throws InterruptedException {
        dialogBoxesPage
                .click()
                .openAlert()
                .getAlertText()
                .name("Ololo")
                .OK()
                .enterNameSuccess("Mariya");
    }

}
