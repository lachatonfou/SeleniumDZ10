package ui.fluent;

import fluentPages.FluentDialogBoxesPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    void HeaderTest() {
        String headerText = dialogBoxesPage
                .getHeader().getSubTitleText();

        assertEquals("Practice site", headerText);
    }
    @Test
    void FooterTest() {
        String footerText = dialogBoxesPage
                .getFooter().getFooterText();

        assertTrue(footerText.contains("2021-2025 Boni"), footerText);
    }
}
