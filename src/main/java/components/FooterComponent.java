package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterComponent {

    private WebDriver driver;

    @FindBy(className = "text-muted")
    @CacheLookup
    private WebElement footer;

    public FooterComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getFooterText() {
        return footer.getText();
    }
}
