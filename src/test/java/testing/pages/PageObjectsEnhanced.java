package testing.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjectsEnhanced extends PageObject {
    public PageObjectsEnhanced(WebDriver driver) {
        super(driver);
    }

    public void type(WebElement e, String value) {
        e.clear();
        e.sendKeys(value);
    }
}
