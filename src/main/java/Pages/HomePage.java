package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @FindBy(xpath = "//input[@placeholder='Search for Vegetables and Fruits']")
    public WebElement search;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement searchButton;

    @FindBy(xpath = "//a[normalize-space()='+']")
    public WebElement IncrementProductCount;
    @FindBy(xpath = "//input[@type=\"number\" and @class=\"quantity\"]")
    public WebElement quantityOfProduct;



    By products = (By.xpath("//div[@class=\"product-image\"]"));


    public boolean searchForVegetables(String enterValue) {
        search.sendKeys(enterValue);
        searchButton.click();
        return true;
    }

    public void addMultipleProduct() throws InterruptedException {
        for (int i=0; i<5; i++){
            wait.until(ExpectedConditions.visibilityOf(IncrementProductCount));
            try{
                IncrementProductCount.click();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            }catch (StaleElementReferenceException ex){
                wait.until(ExpectedConditions.visibilityOf(IncrementProductCount));
                IncrementProductCount.click();
                System.out.println(quantityOfProduct.getAttribute("value"));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            }
        }

    }

    public boolean productCountAvailableOnPage() {
        List<WebElement> productCount = driver.findElements(products);
        int v = (int) productCount.stream().count();

        if (v == 20) {
            System.out.println(v);
            return true;
        }
        System.out.println(v + " " + "& 20 are not same");
        return false;
    }

}
