package Pages;

import org.openqa.selenium.WebDriver;

public class pageObjectManager {
    WebDriver driver;
    HomePage homepage;

    public pageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        homepage = new HomePage(driver);
        return homepage;
    }
}
