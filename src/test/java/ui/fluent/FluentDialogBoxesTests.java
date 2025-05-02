package ui.fluent;

import fluentPages.FluentDialogBoxesPage;
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
    void enterSuccess() {
        dialogBoxesPage
                .click()
                .openAlert()
                .getAlertText()
                .name("Mariya")
                .OK()
                .enterNameSuccess();
    }

    @Test
    void enterNull() {
        dialogBoxesPage
                .click()
                .openAlert()
                .getAlertText()
                .Cancel()
                .enterNull();
    }
}
